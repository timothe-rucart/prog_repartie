import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopieBinaire {

	public static void main(String[] args) {
		
		
		if(args.length != 2){
			System.out.println("2 args nescessaires");
		}else{		
			String src = args[0];
			String dst = args[1];
			File srcF = new File(src);
			File dstF = new File(dst);
			FileInputStream fis = null;
			FileOutputStream fos = null;
			BufferedInputStream bufInputStream = null;
			BufferedOutputStream bufOutputStream = null;
			System.out.println("src : "+src+" , dst : "+dst);
			
			if(srcF.exists()){
				if(!dstF.exists()){
					
					try{
						fis = new FileInputStream(srcF);
						fos = new FileOutputStream(dstF);						
						bufInputStream = new BufferedInputStream(fis);
						bufOutputStream = new BufferedOutputStream(fos);
						
						byte[] buffer = new byte[1];
						
						
						while(bufInputStream.read(buffer) != -1){
							bufOutputStream.write(buffer);			
						}
						
						System.out.println("Copie terminÃ©e !");
						
						
						bufInputStream.close();	
						bufOutputStream.close();
						fis.close();
						fos.close();
						
					}catch(Exception e){
						System.out.println(e.getStackTrace());
					}
					
				}else{
					System.out.println("Le fichier destinataire existe dÃ©ja");
				}
			}else{
				System.out.println("Le fichier source existe pas");
			}
		}	

	}

}
