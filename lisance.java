package gerador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class lisance {
	
	public static void lisanceControl() {
		
		try {
    	    URL url = new URL("https://www.risonetwork.com/lisance.json");//buraya lisance.json dosyasının urlsini giriniz!
    	    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    	    StringBuilder jsonSB = new StringBuilder();
    	    String inputLine;

    	    while ((inputLine = in.readLine()) != null) {
    	        jsonSB.append(inputLine);
    	    }

    	    in.close();

    	    JSONObject jsonObject = new JSONObject(jsonSB.toString());
    	    boolean lisans = jsonObject.getBoolean("license");

    	    if (lisans) {
    	    	//burası lisans doğru ise yapılıcak işlemler
    	        System.out.println("Merhaba! Lisans Aktif");
    	    } else {
    	    	//burası lisans yanlış ise yapılıcak işlemler
    	    	System.out.println("Lisans Bulunamadi Kapatiliyor.");
        	    System.exit(0);
    	    }

    	} catch (IOException e) {//burası lisans bulunamazsa yapılıcak işlemler
    	    System.out.println("Lisans Bulunamadi Kapatiliyor. ");
    	    //buraya warning uyarısı ekleyebilirsin!
    	    System.exit(0);
    	    e.printStackTrace();
    	} catch (JSONException e) {
    	    e.printStackTrace();
    	}
	}

}

//main sınıfta çağırılımı => lisance.lisanceControl();
//ozaii tarafından kodlanmıştır
//json-20230227.jar bu jarı buildpath e ekleyin
//iyi kullanımlar
