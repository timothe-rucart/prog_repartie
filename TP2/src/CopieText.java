import java.io.*;
public class CopieText {

	CopieText(String dst, String src ) throws IOException{

		File f1 = new File(src);
		File f2 = new File(dst);

		if(f1.exists() && !f2.exists()){			

			BufferedReader source = new BufferedReader(new FileReader(src));
			BufferedWriter destination = new BufferedWriter(new FileWriter(dst));

			try{
				int n=0;
				while((n=source.read())>=0){
					destination.write(n);
				}
				source.close();
				destination.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}
		}else{
			System.out.println("pb de fichier");
		}

	}


	public static void main(String[] args) throws IOException{

		CopieText c1 = new CopieText("fichiers/slt.txt","fichiers/yo.txt");
		System.out.println("ok");
	}
}
