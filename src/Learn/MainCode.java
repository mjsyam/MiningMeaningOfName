package Learn;

import java.awt.List;
import java.util.Iterator;

public class MainCode {
	public static void main(String[] args) {
		String nama = "muhammad munir";
		String [] tempPisah = nama.split(" ");
		String namaPertama = "", namaKedua = "", namaKetiga = "";	
		
		int valueOfChart = 0; 
		int valueOfNamaPertama = 0;
		int valueOfNamaKedua = 0;
		int valueOfNamaKetiga = 0;
		
		//Pecah/bagi tiap nama berdasarkan spasi
		for (int i = 0; i < tempPisah.length; i++) {
			if(i == 0){
				namaPertama = tempPisah[0];
			}
			if(i == 1){
				namaKedua = tempPisah[1];
			}
			if(i == 2){
				namaKetiga= tempPisah[2];
			}
		}
		
		
		if(!namaPertama.isEmpty()){
			//Beri nilai pada karakter yang mengandung 2 huruf vokal
			valueOfChart += nilaiKarakterDuaHurufVokal(namaPertama);
			
			//Beri nilai karakter awal dari text/string yang mengandung [aiueo] = 10
			valueOfChart += nilaiKarakterPertamaHurufVokal(namaPertama);
			
			//Ganti karakter terakhir dari text/string yang mengandung [aiueo] menjadi konsonan/t
			namaPertama = gantiKarakterTerakhirHurufVokal(namaPertama);
			
			//Pecah string/text menjadi tiap-tiap karakter berdasarkan huruf vokal 
			String [] namaPertamaTemp = namaPertama.split("[aiueo]");
			valueOfNamaPertama = operasi(namaPertamaTemp);			
		}
		
		if(!namaKedua.isEmpty()){
			//Beri nilai pada karakter yang mengandung 2 huruf vokal
			valueOfChart += nilaiKarakterDuaHurufVokal(namaKedua);
			
			//Beri nilai karakter awal dari text/string yang mengandung [aiueo] = 10
			valueOfChart += nilaiKarakterPertamaHurufVokal(namaKedua);
			
			//Ganti karakter terakhir dari text/string yang mengandung [aiueo] menjadi konsonan/t
			namaKedua = gantiKarakterTerakhirHurufVokal(namaKedua);
			
			//Pecah string/text menjadi tiap-tiap karakter 
			String [] namaKeduaTemp = namaKedua.split("[aiueo]");	
			valueOfNamaKedua = operasi(namaKeduaTemp);
		}
		
		
		if(!namaKetiga.isEmpty()){
			//Beri nilai pada karakter yang mengandung 2 huruf vokal
			valueOfChart += nilaiKarakterDuaHurufVokal(namaKetiga);
			
			//Beri nilai karakter awal dari text/string yang mengandung [aiueo] = 10
			valueOfChart += nilaiKarakterPertamaHurufVokal(namaKetiga);
			
			//Ganti karakter terakhir dari text/string yang mengandung [aiueo] menjadi konsonan/t
			namaKetiga = gantiKarakterTerakhirHurufVokal(namaKetiga);
			
			//Pecah string/text menjadi tiap-tiap karakter 
			String [] namaKetigaTemp = namaKetiga.split("[aiueo]");	
			valueOfNamaKedua = operasi(namaKetigaTemp);
		}
		
		//Jumlahkan hasil nilai
		int sumValue =  valueOfChart + valueOfNamaPertama + valueOfNamaKedua;
		float basis = (float) sumValue/7;
		//Kurangi dengan kelipatan 7
		int finalValue = (int) (sumValue-(Math.floor(basis)*7));
		if(finalValue == 0){
			finalValue += 7;
		}
		
		//System.out.println(basis);
		//System.out.println(valueOfNamaKedua);
		
		System.out.println(sumValue);
		
		System.out.println(artiNama(finalValue));
		
		
	}
	
	public static int operasi(String[] temp){
		int finalvalue = 0;	
		
		//karakter terakhir tidak diberi nilai
		temp[temp.length-1] = "i";
		
		for (int i = 0; i < temp.length; i++) {	
			
			//Filter string array yang mengandung lebih dari 1 karakter
			if(temp[i].length() > 1){
				
				//Bedakan antara karakter yang berada pada index pertama, tengah, dan terakhir
				if(i == 0){
					StringBuffer stringBuffer = new StringBuffer();
					stringBuffer.insert(0, temp[i].charAt(0));
				
					String tempKarakter = stringBuffer.toString();
					temp[i] = tempKarakter;	
				}else{
					StringBuffer stringBuffer = new StringBuffer();
					stringBuffer.insert(0, temp[i].charAt(1));
				
					String tempKarakter = stringBuffer.toString();
					temp[i] = tempKarakter;	
				}
			}
			
			System.out.println(temp[i]);
			
			if(temp[i].equals("s") || temp[i].equals("y")){
				finalvalue += 10;
			}
			
			if(temp[i].equals("r") || temp[i].equals("p") || temp[i].equals("k") || temp[i].equals("f")){
				finalvalue += 8;
			}
			if(temp[i].equals("w") || temp[i].equals("l") || temp[i].equals("g")){
				finalvalue += 6;
			}
			if(temp[i].equals("h")){
				finalvalue += 5;
			}
			if(temp[i].equals("t") || temp[i].equals("d") || temp[i].equals("m")){
				finalvalue += 4;
			}
			if( temp[i].equals("j") || temp[i].equals("z")){
				finalvalue += 3;
			}		
			if(temp[i].equals("n") || temp[i].equals("b")){
				finalvalue += 2;
			}
			
			
		}
		return finalvalue;
	}
	
	public static int nilaiKarakterPertamaHurufVokal(String nama){
		int nilai = 0;
		if(nama.charAt(0) == 'a'
				|| nama.charAt(0) == 'i'
				|| nama.charAt(0) == 'u'
				|| nama.charAt(0) == 'e'
				|| nama.charAt(0) == 'o'){
			nilai = 10;
		}
		return nilai;
	}
	
	public static int nilaiKarakterDuaHurufVokal(String nama){
		int valueOfChart = 0;
		
		char[] hurufVokal = {'a', 'i', 'u','e','o'};
		char tempKarakter = 0; 
		
		for (int i = 1; i < nama.length(); i++) {
			tempKarakter = nama.charAt(i-1);
			for (int j = 0; j < hurufVokal.length; j++) {			
				if(nama.charAt(i) == hurufVokal[j]){
					for (int k = 0; k < hurufVokal.length; k++) {
						if(tempKarakter == hurufVokal[k]){
							valueOfChart = 10;
						}
					}
				}
			}
		}
		
		return valueOfChart;
	}
	
	public static String gantiKarakterTerakhirHurufVokal(String nama){
		String namaString = null;
		if (nama.charAt(nama.length() - 1) == 'a'
				|| nama.charAt(nama.length() - 1) == 'i'
				|| nama.charAt(nama.length() - 1) == 'u'
				|| nama.charAt(nama.length() - 1) == 'e'
				|| nama.charAt(nama.length() - 1) == 'o') {
			namaString = nama + "t";
		}else{
			namaString = nama;
		}
		return namaString;
	}
	public static int karakterPertamaHurufVokal(String nama){
		int nilai = 0;
		if(nama.charAt(0) == 'a'
				|| nama.charAt(0) == 'i'
				|| nama.charAt(0) == 'u'
				|| nama.charAt(0) == 'e'
				|| nama.charAt(0) == 'o'){
			nilai = 10;
		}
		return nilai;
	}
	
	public static String artiNama(int value){
		String artiNama = null;
		
		switch (value) {
		case 1:
			artiNama = "1 Segara --> Hidup Terombang Ambing";
			break;
		case 2:
			artiNama = "2 Menteri Suka --> Suka-suka aja";
			break;
		case 3:
			artiNama = "3 Keranjang Burus --> Selalu Sial";
			break;
		case 4:
			artiNama = "4 Kursi --> Suka Memerintah";
			break;
		case 5:
			artiNama = "5 Gedung Mutakkab --> Orangnya Irit";
			break;
		case 6:
			artiNama = "6 Sumur --> Orang Kaya";
			break;
		case 7:
			artiNama = "7 Bulan Purnama --> Sayang Diri Sendiri";
			break;
			
		default:
			break;
		}		
		return artiNama;
	}
}
