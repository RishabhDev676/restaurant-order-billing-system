# 📖 Foodie's Paradise - User & Technical Guide

Welcome to the **Foodie's Paradise Restaurant Order and Billing System** documentation.

---

## 🎯 System Workflow

1. **Category & Item Selection**:
   - Use the **Select Category** dropdown to filter items (e.g., Main Course, South Indian, Fast Food, Beverages & Desserts).
   - Choose the desired item from **Select Menu Item**.

2. **Quantity Adjustment**:
   - Use the **Quantity** spinner control to increase/decrease the quantity or enter a number directly.

3. **Building the Order**:
   - Click **Add Item to Order** (`btnAddOrder`).
   - The item is added to the active order in `BillingManager`.
   - The **Live Receipt & Order Summary** panel displays the itemized list with live subtotal and estimated 5% GST.

4. **Generating Total Bill**:
   - Click **Generate Total Bill** (`btnTotalBill`).
   - Generates the official thermal receipt with Bill Serial Number, Timestamp, Subtotal, CGST (2.5%), SGST (2.5%), and Grand Total.

5. **Printing & Clearing**:
   - Click **Print Receipt** (`btnPrint`) to open the native printer dialog.
   - Click **Clear / New Order** (`btnClear`) to reset the current order state.

---

## 🧩 Architecture Details

- **`Main.java`**: Launches `RestaurantBillingSystem` frame on `EventQueue.invokeLater`.
- **`RestaurantBillingSystem.java`**: Extends `JFrame`. Implements custom component wiring inside `customInit()`.
- **`GradientHeaderPanel.java`**: Extends `JPanel`. Overrides `paintComponent` with `Graphics2D` for gradient fill.
- **`CardPanel.java`**: Extends `JPanel`. Overrides `paintComponent` with `RoundRectangle2D` for smooth rounded card borders.
- **`ModernVibrantButton.java`**: Extends `JButton`. Overrides `paintComponent` with anti-aliasing and hover state listeners.
- **`MenuManager.java`**: Stores item names, prices, and category maps.
- **`BillingManager.java`**: Holds list of `OrderItem` objects and calculates subtotal.
- **`ReceiptGenerator.java`**: Formats thermal receipts and live summaries.

---

## 🛠️ Troubleshooting NetBeans Form Issues

If NetBeans IDE displays a form warning:
1. Ensure `RestaurantBillingSystem.form` and `RestaurantBillingSystem.java` are in the same folder (`src/com/restaurant/`).
2. Run **Clean and Build** (`Shift + F11`) in NetBeans.
3. Open `RestaurantBillingSystem.java` and click **Design**.
