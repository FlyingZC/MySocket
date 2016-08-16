package com.zc.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//获取内网所有IP
public class T01PingIP extends Thread{
	public String ip;
	public Map<String,String> pingMap=new HashMap<String,String>();
	public T01PingIP(){
		this.ip=ip;
	}
	
	@Override
	public void run() {
		try {
			Process process=Runtime.getRuntime().exec("ping"+ip+"-w 280 -n 1");
			InputStream is=process.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String line=br.readLine();
			while(line!=null){
				if(line!=null&&!line.equals("")){
					if((line.substring(0,2)).equals("来自")||(line.length()>10&&line.substring(0,10).equals("Reply from"))){
						pingMap.put(ip,"true");
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
