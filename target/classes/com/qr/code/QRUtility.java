package com.qr.code;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/*
 * ZXing QR Code generator for Payments
 * ZXing uses 8 bit masks for QR code generation.
 */

public class QRUtility {
	
	static boolean isAchieveFastFlickerFreeUpdates = true;

	public static void main(String args[]) throws WriterException {

		QRCodeWriter barcodeWriter = new QRCodeWriter();
		
	    //BitMatrix bitMatrixSmall = barcodeWriter.encode("Covid-19 ContactLess Payments", BarcodeFormat.QR_CODE, 600, 600);
	
		//BitMatrix bitMatrixMedium = barcodeWriter.encode("Covid-19 ContactLess Payments", BarcodeFormat.QR_CODE, 700, 700);
		
		BitMatrix bitMatrixLarge = barcodeWriter.encode("Covid-19 ContactLess Payments", BarcodeFormat.QR_CODE, 1200, 800);
		
		BufferedImage img = MatrixToImageWriter.toBufferedImage(bitMatrixLarge);

		generateQRImage(img);
	}

	public static void generateQRImage(Image image) {
		
		JLabel label = new JLabel(new ImageIcon(image));
	
		JLabel tlabel = new JLabel("PayPal Pay",JLabel.CENTER);

		JPanel panel = new JPanel(isAchieveFastFlickerFreeUpdates);
		panel.add(label);
		panel.add(tlabel);

		JScrollPane scrollPane = new JScrollPane(panel);
		JOptionPane.showMessageDialog(null, scrollPane);
	}
}
