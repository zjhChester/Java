package test;

import java.awt.Toolkit;  
import java.awt.datatransfer.Clipboard;  
import java.awt.datatransfer.DataFlavor;  
import java.awt.datatransfer.StringSelection;  
import java.awt.datatransfer.UnsupportedFlavorException;  
import java.io.IOException;  
  
  
  
public class CopyAndPaste {  
    public static void main(String[] args) {  
        copy();   //���� �ڼ����� ctrl + v  
        paste();  
    }  
      
    public static void copy(){  
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  //�õ�ϵͳ������  
        String text = "����Ҫ����������111";  
        StringSelection selection = new StringSelection(text);  
        clipboard.setContents(selection, null);  
    }  
      
    public static void paste(){  
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  
        DataFlavor flavor = DataFlavor.stringFlavor;  
        if(clipboard.isDataFlavorAvailable(flavor)){//�Ƿ���ϼ��������������  
            try {  
                System.out.println("��ʱ������������ǣ�" + clipboard.getData(flavor));  
            } catch (UnsupportedFlavorException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}