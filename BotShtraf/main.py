import telebot
import config
import re
import time #Абуз
import mysql.connector

from telebot import types


bot = telebot.TeleBot(config.TOKEN)
conn = mysql.connector.connect(
       host='127.0.0.1',
       user='oscirt',
       password='12345',
       database='fines_app'
   )
user_car = 'Нет данных'
user_ctc = 'Нет данных'
user_car1 = ''
user_ctc1 = ''

@bot.message_handler(commands=['start'])
def welcome(message):
    stik = open('venv/maloy.webp', 'rb')
    bot.send_sticker(message.chat.id, stik)

    markup = types.ReplyKeyboardMarkup(resize_keyboard=True)
    button1 = types.KeyboardButton('👮 Проверить штрафы ГИБДД')
    button2 = types.KeyboardButton('📖 Профиль')
    markup.add(button1, button2)

    bot.send_message(message.chat.id,
                     "Здравствуйте, {0.first_name}!\nЗдесь вы можете проверить свои штрафы ГИБДД, "
                     "оплатить их и получать уведомления о "
                     "новых.".format(message.from_user, bot.get_me()), parse_mode='html', reply_markup=markup)


@bot.message_handler(content_types=['text'])
def messages(message):
    if message.chat.type == 'private':
        if message.text == '👮 Проверить штрафы ГИБДД':
            bot.reply_to(message,
                             'Проверка штрафов запущена, для этого понадобится ваш номер автомобиля и '
                             'номер свидетельства о регистрации ТС')
            bot.send_message(message.chat.id,
                             '🚘 Пункт 1/2 Какой у вас номер автомобиля?\n\n Для поиска возможных нарушений. '
                             'Например, А123БВ 123')
            bot.register_next_step_handler(message, carnumber)
        elif message.text == '📖 Профиль':
            markup = types.InlineKeyboardMarkup()
            markup.add(types.InlineKeyboardButton('Удалить данные профиля', callback_data='delete_profile'))
            markup.add(types.InlineKeyboardButton('Оплатить штрафы', callback_data='payment')) # Добавить иф штрафы есть
            bot.send_message(message.chat.id, f'{message.from_user.first_name}, ваш профиль пользователя:\n'
                                              f'Ваш id: {message.from_user.id}\n'
                                              f'Ваш номер автомобиля: {user_car}\n' # Абузы, пофиксить когда будет SQL
                                              f'Ваш номер свидетельства о регистрации ТС: {user_ctc}', reply_markup=markup) # Добавить инфу о штрафах
        else:
            bot.send_message(message.chat.id, 'Неизвестная команда')

def carnumber(message):
    car_number = message.text.upper()
    pattern = r'^[А-Я]{1}\d{3}[А-Я]{2}\s\d{2,3}$'
    if message.text == '/start':
        welcome(message)
    elif not re.match(pattern, car_number):
        message = bot.send_message(message.chat.id,
                                   'Номер машины некорректен,\nВведите корректный номер машины')
        bot.register_next_step_handler(message, carnumber)
    else:
        global user_car1 # Абуз
        user_car1 = message.text # Абуз, сохраняем номер пока в буф
        bot.send_message(message.chat.id,
                         '🚘 Пункт 2/2 Какой номер свидетельства о регистрации ТС?\n\n Для проверки штрафов с камер. '
                         'Например, МО 123456')
        bot.register_next_step_handler(message, ctc)

def ctc(message):
    ctc_number = message.text.upper()
    pattern = r'^[А-Я]{2} \d{6}$'
    if not re.match(pattern, ctc_number):
        message = bot.send_message(message.chat.id,
                                   'Номер СТС некорректен,\nВведите корректный номер машины ')
        bot.register_next_step_handler(message, ctc)
    else:
        global user_ctc1 # Абуз
        user_ctc1 = message.text # Абуз, сохраняем номер пока в буф
        profile_save(message)

def profile_save(message):
    markup = types.InlineKeyboardMarkup()
    button1 = types.InlineKeyboardButton('Да', callback_data='save')
    button2 = types.InlineKeyboardButton('Нет', callback_data='dontsave')
    markup.row(button1, button2)
    bot.send_message(message.chat.id, 'Сохранить данные в профиль?', reply_markup=markup)

def fines_check(message): # Жесточайший абуз
    bot.send_message(message.chat.id, '🤖 Проверяем штрафы. Пожалуйста, подождите')
    time.sleep(5)
    bot.send_message(message.chat.id, '🎉 У вас нет неоплаченных штрафов! Если они появятся, мы вам сообщим')
    markup = types.InlineKeyboardMarkup()
    markup.add(types.InlineKeyboardButton('Оплатить штрафы', callback_data='payment'))  # Добавить иф штрафы есть
    bot.send_message(message.chat.id, '😔 У вас есть неоплаченные штрафы! Оплатить можно сейчас или в профиле', reply_markup=markup)

@bot.callback_query_handler(func=lambda callback: True)
def callback_message(callback): # половина функции абузы
    global user_ctc
    global user_ctc1
    global user_car
    global user_car1
    if callback.data == 'save': # Абуз
        bot.delete_message(callback.message.chat.id, callback.message.message_id)
        user_car = user_car1
        user_ctc = user_ctc1
        user_car1 = ''
        user_ctc1 = ''
        bot.send_message(callback.message.chat.id, 'Данные сохранены')
        fines_check(callback.message)
    elif callback.data == 'dontsave': # Абуз
        user_car1 = ''
        user_ctc1 = ''
        bot.send_message(callback.message.chat.id, 'Данные не будут сохранены')
        fines_check(callback.message)
    elif callback.data == 'delete_profile':  # Абуз
        user_car = 'Нет данных'
        user_ctc = 'Нет данных'
        bot.edit_message_reply_markup(callback.message.chat.id, callback.message.message_id)
        bot.send_message(callback.message.chat.id, 'Данные удалены')
    elif callback.data == 'payment':
        bot.edit_message_reply_markup(callback.message.chat.id, callback.message.message_id)
        bot.send_message(callback.message.chat.id, 'Здесь будет оплата')


bot.polling(none_stop=True)
