# 📦 How to Create a GitHub Release

Follow these steps to make your ATM Simulator available for download:

## Step 1: Navigate to Releases

1. Go to your repository: **https://github.com/Rohankhaire/Bank-Simulator**
2. Click on **"Releases"** in the right sidebar (or go to: https://github.com/Rohankhaire/Bank-Simulator/releases)
3. Click the **"Create a new release"** button

## Step 2: Fill in Release Details

### Tag Version
- Click **"Choose a tag"**
- Type: `v1.0.0`
- Click **"Create new tag: v1.0.0 on publish"**

### Release Title
```
ATM Simulator v1.0.0 - Initial Release
```

### Description
```markdown
# 🏦 ATM Simulator v1.0.0

A comprehensive ATM Simulator built with Java Swing and PostgreSQL.

## ✨ Features

- 🔐 Secure user authentication
- 💰 Cash deposit and withdrawal
- ⚡ Fast cash options
- 📊 Balance inquiry
- 📄 Mini statement generation
- 🔑 PIN change functionality
- 🎨 Modern, user-friendly interface

## 📋 System Requirements

- **Java Runtime Environment (JRE) 8 or higher**
- **PostgreSQL Database Server**
- **Windows/Linux/Mac OS**

## 🚀 Quick Start

### For Windows Users:
1. Download `ATM-Simulator-v1.0.0.zip`
2. Extract the ZIP file
3. Double-click `Atm_Simulator_Application.jar` or run `ATM-1.0.exe`

### For Linux/Mac Users:
1. Download `ATM-Simulator-v1.0.0.zip`
2. Extract the ZIP file
3. Open terminal in the extracted folder
4. Run: `java -jar Atm_Simulator_Application.jar`

## 🗄️ Database Setup

1. Install PostgreSQL
2. Create a database named `bankmanagementsystem`
3. Update connection details in the application if needed

## 📖 Documentation

See [README.md](https://github.com/Rohankhaire/Bank-Simulator/blob/master/README.md) for detailed setup instructions.

## 🐛 Known Issues

None reported yet. Please report issues [here](https://github.com/Rohankhaire/Bank-Simulator/issues).

## 📞 Support

For questions or issues, please open an issue on GitHub.

---

**Full Changelog**: Initial Release
```

## Step 3: Upload Files

Click **"Attach binaries by dropping them here or selecting them"** and upload:

1. **ATM-Simulator-v1.0.0.zip** (from your project root)
2. **ATM-1.0.exe** (optional - the Windows executable)

## Step 4: Publish

1. Make sure **"Set as the latest release"** is checked
2. Click **"Publish release"**

## 🎉 Done!

Your application is now available for download at:
**https://github.com/Rohankhaire/Bank-Simulator/releases**

Users can download and run your ATM Simulator!

---

## 📸 Adding Screenshots (Optional but Recommended)

To make your release more attractive:

1. Take screenshots of your application
2. Upload them to an image hosting service or add to your repository
3. Include them in the release description using:
   ```markdown
   ![Screenshot](URL_TO_IMAGE)
   ```

## 🔄 Future Releases

When you make updates:

1. Update version number (e.g., `v1.1.0`, `v2.0.0`)
2. Create a new release
3. List changes in the description
4. Upload updated files
