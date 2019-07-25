package test;

import java.awt.Toolkit;  
import java.awt.datatransfer.Clipboard;  
import java.awt.datatransfer.DataFlavor;  
import java.awt.datatransfer.StringSelection;  
import java.awt.datatransfer.UnsupportedFlavorException;  
import java.io.IOException;  
  
  
  
public class CopyAndPaste {  
    public static void main(String[] args) {  
        copy();   //可以 在键盘上 ctrl + v  
        paste();  
    }  
      
    public static void copy(){  
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  //得到系统剪贴板  
        String text = "这是要拷贝的内容111";  
        StringSelection selection = new StringSelection(text);  
        clipboard.setContents(selection, null);  
    }  
      
    public static void paste(){  
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  
        DataFlavor flavor = DataFlavor.stringFlavor;  
        if(clipboard.isDataFlavorAvailable(flavor)){//是否符合剪贴板的数据类型  
            try {  
                System.out.println("此时剪贴版的数据是：" + clipboard.getData(flavor));  
            } catch (UnsupportedFlavorException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}