codesign --force --deep --sign - build/macApp/DayCare.app
sudo xattr -rd com.apple.quarantine build/macApp/DayCare.app