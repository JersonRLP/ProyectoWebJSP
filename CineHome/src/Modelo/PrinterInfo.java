package Modelo;

import java.awt.print.PrinterJob;

public class PrinterInfo {

	public static void main(String[] args) {
		PrinterJob printerJob = PrinterJob.getPrinterJob();
        String defaultPrinter = printerJob.getPrintService().getName();
        System.out.println("Impresora predeterminada: " + defaultPrinter);
	}

}
