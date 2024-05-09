package org.example.payment_service.service;

import io.nayuki.qrcodegen.QrCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.payment_service.dto.FineDto;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QrGenService {

    Logger logger = LogManager.getLogger();

    public byte[] generate(FineDto fineDto) {
        QrCode qr = QrCode.encodeText(fineDto.getRequisites(), QrCode.Ecc.HIGH);
        BufferedImage result = new BufferedImage(
                (qr.size + 4 * 2) * 10,
                (qr.size + 4 * 2) * 10,
                BufferedImage.TYPE_INT_RGB
        );
        for (int y = 0; y < result.getHeight(); y++) {
            for (int x = 0; x < result.getWidth(); x++) {
                boolean color = qr.getModule(x / 10 - 4, y / 10 - 4);
                result.setRGB(x, y, color ? 0x000000 : 0xFFFFFF);
            }
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ImageIO.write(result, "png", stream);
        } catch (IOException e) {
            logger.error("Cannot write buffered image: %s".formatted(e));
        }
        return stream.toByteArray();
    }
}
