package test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class TestCase {
	public static void main(String[] args) throws IOException{
	    
	    String itemIdArray = "aaa";
        String[] itemArray = itemIdArray.split(" ");
	    for(int i=0;i<itemArray.length;i++){
	        System.out.println(itemArray[i]);
	    }

	}
	
	public static void deleteOldData(File file) throws IOException{
	    
	    if (file.exists() && file.isDirectory()) {
            for (File subf : file.listFiles()) {
                if (subf.isDirectory()) {
                    checkDateAndDelete(new File(subf.getAbsolutePath()));
                }
            }
        }
	}
	
	public static void checkDateAndDelete(File file) throws IOException{
	    Calendar calnow = Calendar.getInstance();
        Calendar cal=Calendar.getInstance();
        
        Date datenow = new Date();
        calnow.setTime(datenow);
        
        Date date_modify = new Date(file.lastModified());
        cal.setTime(date_modify);
        
        int dec = calnow.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
        System.out.println(dec);
        if (dec >= 1) {
            delFileOrDir(file);
        }
	}
	
    public static void delFileOrDir(File f) throws IOException {

        if ((f == null)) {
            throw new IllegalArgumentException("Argument " + f + " is not a file or directory. ");
        }
        if (f.exists() && f.isDirectory()) {
            if (f.listFiles().length == 0) {
                f.delete();
            } else {
                File delFiles[] = f.listFiles();
                for (File subf : delFiles) {
                    if (subf.isDirectory()) {
                        delFileOrDir(new File(subf.getAbsolutePath()));// Recursive
                    }
                    subf.delete();
                }
                f.delete();
            }
        }
    }
	
//	static public void deleteDirectory(File dir) throws IOException {
//        if( (dir == null) || !dir.isDirectory()) {
//            throw new IllegalArgumentException(
//                      "Argument "+dir+" is not a directory. "
//                  );
//        }
//
//        File[ ] entries = dir.listFiles( );
//        int sz = entries.length;
//
//        for(int i=0; i<sz; i++) {
//            if(entries[i].isDirectory( )) {
//                deleteDirectory(entries[i]);
//            } else {
//                entries[i].delete( );
//            }
//        }
//
//       dir.delete();
//    } 
    
    public static String[] getStringList(String... stringList){
        return stringList;
    }
    
    
	  
}