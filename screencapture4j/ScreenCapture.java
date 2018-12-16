package screencapture4j;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.jna.Memory;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HBITMAP;
import com.sun.jna.platform.win32.WinDef.HDC;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinGDI;
import com.sun.jna.platform.win32.WinGDI.BITMAPINFO;
import com.sun.jna.platform.win32.WinNT.HANDLE;

import de.me.linus.jf.framework.utils.screen_utils.GDI32Extra;
import de.me.linus.jf.framework.utils.screen_utils.User32Extra;
import de.me.linus.jf.framework.utils.screen_utils.WinGDIExtra;

public class ScreenCapture {

	public String windowName = "";
	
	public HWND hWnd = null;
	public Files files = null;
	public BufferedImage image = null;
	
	public ScreenCapture() {
		this.files = new Files();
	}
	
	public ScreenCapture(String frameName) {
		this.files = new Files();
		this.windowName = frameName;
	}
	
	public void setWindow(String windowName) {
		this.windowName = windowName;
	}
	
	public BufferedImage current_image() {
		this.hWnd = User32.INSTANCE.FindWindow(null, this.windowName);
		return this.image;
	}
	
	public BufferedImage capture(HWND hWnd) {
        HDC hdcWindow = User32.INSTANCE.GetDC(hWnd);
        HDC hdcMemDC = GDI32.INSTANCE.CreateCompatibleDC(hdcWindow);

        RECT bounds = new RECT();
        User32Extra.INSTANCE.GetClientRect(hWnd, bounds);

        int width = bounds.right - bounds.left;
        int height = bounds.bottom - bounds.top;

        HBITMAP hBitmap = GDI32.INSTANCE.CreateCompatibleBitmap(hdcWindow, width, height);

        HANDLE hOld = GDI32.INSTANCE.SelectObject(hdcMemDC, hBitmap);
        GDI32Extra.INSTANCE.BitBlt(hdcMemDC, 0, 0, width, height, hdcWindow, 0, 0, WinGDIExtra.SRCCOPY);

        GDI32.INSTANCE.SelectObject(hdcMemDC, hOld);
        GDI32.INSTANCE.DeleteDC(hdcMemDC);

        BITMAPINFO bmi = new BITMAPINFO();
        bmi.bmiHeader.biWidth = width;
        bmi.bmiHeader.biHeight = -height;
        bmi.bmiHeader.biPlanes = 1;
        bmi.bmiHeader.biBitCount = 32;
        bmi.bmiHeader.biCompression = WinGDI.BI_RGB;

        Memory buffer = new Memory(width * height * 4);
        GDI32.INSTANCE.GetDIBits(hdcWindow, hBitmap, 0, height, buffer, bmi, WinGDI.DIB_RGB_COLORS);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        image.setRGB(0, 0, width, height, buffer.getIntArray(0, width * height), 0, width);

        GDI32.INSTANCE.DeleteObject(hBitmap);
        User32.INSTANCE.ReleaseDC(hWnd, hdcWindow);

        return image;
    }
	
	/**
	 * [param: type] formats: "jpg", "png", "gif"
	 * 
	 * @param fileName
	 * @param type 
	 */
	public void save_image(String fileName, String type) {
		Strings.print_Console("Save image...");
		try {
			ImageIO.write(this.current_image(), type, this.files.createFileInFolder("saved_images", fileName));
		} catch (IOException e) {}
		Strings.print_Console("Image saved!");
	}
}
