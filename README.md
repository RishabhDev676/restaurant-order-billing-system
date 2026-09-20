# 🍽️ Serve & Settle - Restaurant Order and Billing System

A modern, high-performance desktop application developed in **Java Swing** for managing restaurant menu items, order placement, live order summaries, and itemized thermal receipt generation.

Designed with a **vibrant gourmet color palette**, **responsive full-screen layout**, and **100% NetBeans Matisse GUI Builder compatibility**.

---

## ✨ Features

- **🎨 Vibrant Modern UI System**:
  - Gradient header banner (Coral Red `#FF4B4B` to Golden Mango `#FF8C00`).
  - Card-based modular layout (`CardPanel`) with rounded corners and high-contrast typography.
  - Interactive custom buttons (`ModernVibrantButton`) with smooth anti-aliasing, hover effects, and click feedback.
- **🖥️ Auto Full-Screen Mode**: Automatically launches in maximized mode (`MAXIMIZED_BOTH`) across all screen sizes.
- **🔢 Native Quantity Spinner (`JSpinner`)**: Integrated up/down stepper control with custom centered typography and automatic range validation (1–999).
- **🛒 Categorized Menu Selection**: Filter food items by category (Main Course, South Indian, Fast Food, Beverages & Desserts).
- **📊 Live Order Summary**: Displays added items in real-time with subtotal and estimated GST preview.
- **🧾 Thermal Receipt Generator**:
  - Itemized table layout with exact price and quantity columns.
  - Automatic tax calculation (**CGST 2.5%** + **SGST 2.5%** = **5% GST**).
  - Dynamic invoice/bill numbering (`FP-1001`, `FP-1002`, etc.) and real-time timestamping.
  - Warm receipt paper styling with one-click print support.
- **📐 NetBeans Matisse GUI Builder Integration**: Includes `RestaurantBillingSystem.form` and guarded block structure for full visual **Design** tab support in NetBeans IDE.

---

## 🛠️ Tech Stack & Architecture

- **Language**: Java (JDK 17+)
- **GUI Framework**: Java Swing (`javax.swing`, `java.awt`)
- **IDE**: Apache NetBeans IDE
- **Build System**: Apache Ant (`build.xml`)

---

## 📂 Project Structure

```
RestaurantBillingSystem/
│
├── assets/
│   └── screenshots/
├── docs/
│   └── USER_GUIDE.md
├── nbproject/
│   ├── build-impl.xml
│   ├── project.properties
│   └── project.xml
├── src/
│   └── com/
│       └── restaurant/
│           ├── Main.java                      # Main application entry point
│           ├── RestaurantBillingSystem.java   # JFrame Window & UI Logic
│           ├── RestaurantBillingSystem.form   # NetBeans Matisse Form Metadata
│           ├── bg.png                         # Application Background Image
│           ├── logo.png                       # Application Logo Image
│           ├── GradientHeaderPanel.java       # Custom Gradient Banner Panel
│           ├── CardPanel.java                 # Custom Rounded Card Container
│           ├── ModernVibrantButton.java       # Custom Animated Button
│           ├── MenuManager.java               # Menu & Category Data Model
│           ├── BillingManager.java            # Active Order & Pricing Logic
│           └── ReceiptGenerator.java          # Thermal Receipt & Summary Formatter
├── .gitignore
├── README.md
├── build.xml
└── manifest.mf
```

---

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK)** 17 or higher
- **Apache NetBeans IDE** (recommended)

---

### Running in NetBeans IDE

1. **Clone the repository**:
   ```bash
   git clone https://github.com/RishabhDev676/restaurant-order-billing-system.git
   ```
2. **Open Project**:
   - In NetBeans, go to `File` ➔ `Open Project...` (`Ctrl + Shift + O`).
   - Select the `RestaurantBillingSystem` directory.
3. **Clean & Build**:
   - Right-click the project in the left panel and click **Clean and Build** (`Shift + F11`).
4. **Run Application**:
   - Press **`F6`** (or click the green Play ▶ button).
5. **Visual Design Editor**:
   - Double-click `RestaurantBillingSystem.java` and click the **Design** tab at the top of the editor.

---

### Running via Terminal

```bash
# Compile source files
javac -d bin -cp src src/com/restaurant/*.java

# Run main application
java -cp bin com.restaurant.Main
```

---

## 📄 License & Credits

Developed for educational purposes as part of the Advanced Java Billing System project.  
**Author**: [RishabhDev676](https://github.com/RishabhDev676)
