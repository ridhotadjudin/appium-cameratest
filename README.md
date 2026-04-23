# 📱 Appium CameraTest

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Appium](https://img.shields.io/badge/Appium-8.1.1-6C3FD1?style=flat-square&logo=appium&logoColor=white)
![Android](https://img.shields.io/badge/Android-Mobile-3DDC84?style=flat-square&logo=android&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-7.3.4-23D96C?style=flat-square&logo=cucumber&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-7.6.0-FF7300?style=flat-square&logo=testng&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

Automated mobile test suite for the **CameraTest** Android application built with **Appium**, **Cucumber BDD**, and **TestNG**. The framework validates camera functionality across Android devices and emulators using the Page Object Model pattern with Gherkin-based scenarios, producing rich HTML reports via ExtentReports.

---

## 📑 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Getting Started](#-getting-started)
- [Test Scenarios](#-test-scenarios)
- [Design Patterns](#-design-patterns)
- [Reports](#-reports)
- [Author](#-author)

---

## ✨ Features

- End-to-end camera app testing on Android devices and emulators
- BDD test scenarios written in Gherkin for clear, readable specifications
- Page Object Model for maintainable and reusable UI interactions
- Automatic screenshot capture saved to `hasilSS/` on test execution
- Rich HTML reporting with ExtentReports including step-level detail
- TestNG suite management via `CameraTestSuite.xml`
- Parallel-ready test execution through TestNG configuration

---

## 🛠 Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 17 | Programming language |
| Maven | 3.8+ | Build and dependency management |
| Selenium | 4.0.0 | WebDriver base framework |
| Appium Java Client | 8.1.1 | Mobile automation driver |
| TestNG | 7.6.0 | Test execution and suite management |
| Cucumber | 7.3.4 | BDD framework with Gherkin syntax |
| ExtentReports | 4.0.9 | HTML test report generation |
| Android SDK | 30+ | Android platform tools and emulator |

---

## 📁 Project Structure

```
appium-cameratest/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/               # Page Object classes
│   │           └── CameraPage.java
│   └── test/
│       ├── java/
│       │   ├── runners/             # TestNG + Cucumber runner
│       │   │   └── TestRunner.java
│       │   ├── stepdefinitions/     # Cucumber step definitions
│       │   │   └── CameraSteps.java
│       │   └── utils/               # Utilities and driver setup
│       │       ├── DriverManager.java
│       │       └── ReportManager.java
│       └── resources/
│           └── features/            # Gherkin feature files
│               └── camera.feature
├── hasilSS/                         # Screenshots output directory
├── CameraTestSuite.xml              # TestNG suite configuration
├── extent.html                      # Generated ExtentReports output
├── pom.xml
└── README.md
```

---

## 📋 Prerequisites

| Requirement | Details |
|---|---|
| **JDK** | Java 17 or higher installed and `JAVA_HOME` configured |
| **Maven** | Apache Maven 3.8+ with `mvn` available on PATH |
| **Android SDK** | Android SDK installed with `ANDROID_HOME` set and platform-tools on PATH |
| **Appium Server** | Appium 2.x installed globally via `npm install -g appium` |
| **UiAutomator2 Driver** | Installed via `appium driver install uiautomator2` |
| **Android Device** | Physical device with USB debugging enabled or an Android emulator running |

---

## 🚀 Getting Started

**1. Clone the repository**

```bash
git clone https://github.com/ridhotadjudin/appium-cameratest.git
cd appium-cameratest
```

**2. Install dependencies**

```bash
mvn clean install -DskipTests
```

**3. Start the Appium server**

```bash
appium
```

**4. Connect an Android device or launch an emulator**

```bash
emulator -avd <avd_name>
```

Verify the device is detected:

```bash
adb devices
```

**5. Run the test suite**

```bash
mvn test -DsuiteXmlFile=CameraTestSuite.xml
```

**6. View the report**

Open `extent.html` in a browser after test execution completes.

---

## 🧪 Test Scenarios

| Scenario | Description | Expected Result |
|---|---|---|
| Open Camera App | Launch the CameraTest application on the device | App opens and camera preview is displayed |
| Capture Photo | Tap the capture button to take a photo | Photo is captured and saved successfully |
| Switch Camera | Toggle between front and rear cameras | Camera view switches without errors |
| View Gallery | Navigate to the gallery from the camera screen | Captured photos are listed in the gallery |
| Delete Photo | Select and delete a photo from the gallery | Photo is removed from the gallery |
| Camera Permissions | Verify permission prompt on first launch | Permission dialog is displayed and functional |
| Flash Toggle | Toggle flash mode on and off | Flash mode changes and indicator updates |

---

## 🏗 Design Patterns

### Page Object Model (POM)

Each screen of the CameraTest app is represented by a dedicated page class that encapsulates element locators and user interactions. This separation keeps test logic independent of UI structure, making tests resilient to UI changes.

```java
public class CameraPage {
    @AndroidFindBy(id = "com.camera.test:id/btn_capture")
    private WebElement captureButton;

    public void tapCapture() {
        captureButton.click();
    }
}
```

### Behavior-Driven Development (BDD)

Test scenarios are written in Gherkin syntax inside `.feature` files, providing a shared language between technical and non-technical stakeholders.

```gherkin
Feature: Camera Capture

  Scenario: User captures a photo
    Given the CameraTest app is open
    When the user taps the capture button
    Then a photo is saved successfully
```

Step definitions in Java bind the Gherkin steps to Appium automation logic, and the TestNG runner in `CameraTestSuite.xml` orchestrates execution.

---

## 📊 Reports

Test results are generated as a rich HTML report using **ExtentReports 4.0.9**.

- **Output file:** `extent.html` in the project root
- **Screenshots:** Captured automatically and stored in `hasilSS/`
- **Report includes:** Test pass/fail status, step-level details, timestamps, and embedded screenshots on failure

Open the report after execution:

```bash
start extent.html
```

---

## 👤 Author

**Ridho Tadjudin**

- 🌐 Website: [ridhotadjudin.id](https://ridhotadjudin.id)
- 💻 GitHub: [@ridhotadjudin](https://github.com/ridhotadjudin)
