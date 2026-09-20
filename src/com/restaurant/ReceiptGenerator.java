package com.restaurant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Utility class to format thermal-style restaurant receipts and live order summaries.
 */
public class ReceiptGenerator {

    private static int orderCounter = 1001;

    public static String generateReceipt(List<BillingManager.OrderItem> items, double subtotal) {
        double gst = subtotal * 0.05;
        double grandTotal = subtotal + gst;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = formatter.format(new Date());

        StringBuilder sb = new StringBuilder();
        sb.append("=================================================\n");
        sb.append("               SERVE & SETTLE                  \n");
        sb.append("       Fine Dining & Quick Order Service         \n");
        sb.append("             GSTIN: 27AAAAA0000A1Z5              \n");
        sb.append("=================================================\n");
        sb.append(String.format(" Bill No    : FP-%d\n", orderCounter++));
        sb.append(String.format(" Date & Time: %s\n", dateTime));
        sb.append("-------------------------------------------------\n");
        sb.append(String.format(" %-22s %-4s %-8s %-10s\n", "ITEM NAME", "QTY", "PRICE", "TOTAL"));
        sb.append("-------------------------------------------------\n");

        for (BillingManager.OrderItem item : items) {
            String name = item.getName();
            if (name.length() > 22) {
                name = name.substring(0, 19) + "...";
            }
            sb.append(String.format(" %-22s x%-3d ₹%-7.2f ₹%-9.2f\n",
                    name, item.getQuantity(), item.getUnitPrice(), item.getTotalPrice()));
        }

        sb.append("-------------------------------------------------\n");
        sb.append(String.format(" Sub Total                 :           ₹%.2f\n", subtotal));
        sb.append(String.format(" CGST (2.5%%)               :           ₹%.2f\n", gst / 2.0));
        sb.append(String.format(" SGST (2.5%%)               :           ₹%.2f\n", gst / 2.0));
        sb.append("-------------------------------------------------\n");
        sb.append(String.format(" GRAND TOTAL               :           ₹%.2f\n", grandTotal));
        sb.append("=================================================\n");
        sb.append("            Payment Mode: CASH / CARD            \n");
        sb.append("            Thank You For Dining With Us!        \n");
        sb.append("                Please Visit Again!              \n");
        sb.append("=================================================\n");
        return sb.toString();
    }

    public static String generateLiveSummary(List<BillingManager.OrderItem> items) {
        if (items.isEmpty()) {
            return "";
        }
        double subtotal = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------------------\n");
        sb.append("             LIVE ORDER SUMMARY                  \n");
        sb.append("-------------------------------------------------\n");
        sb.append(String.format(" %-22s %-4s %-8s %-10s\n", "ITEM NAME", "QTY", "PRICE", "TOTAL"));
        sb.append("-------------------------------------------------\n");

        for (BillingManager.OrderItem item : items) {
            String name = item.getName();
            if (name.length() > 22) {
                name = name.substring(0, 19) + "...";
            }
            sb.append(String.format(" %-22s x%-3d ₹%-7.2f ₹%-9.2f\n",
                    name, item.getQuantity(), item.getUnitPrice(), item.getTotalPrice()));
            subtotal += item.getTotalPrice();
        }

        double gst = subtotal * 0.05;
        double grandTotal = subtotal + gst;

        sb.append("-------------------------------------------------\n");
        sb.append(String.format(" Subtotal                  :           ₹%.2f\n", subtotal));
        sb.append(String.format(" GST (5%%)                  :           ₹%.2f\n", gst));
        sb.append(String.format(" ESTIMATED TOTAL           :           ₹%.2f\n", grandTotal));
        sb.append("-------------------------------------------------\n");
        return sb.toString();
    }
}
