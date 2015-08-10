package Thumbtack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class SimpleDatabase {
	
	private HashMap<String,LinkedList<Integer>> db;
	
	public SimpleDatabase() {
		db = new HashMap<String,LinkedList<Integer>>();
	}
	
	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				FileInputStream in = new FileInputStream(args[0]);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String str;
				while ((str = br.readLine()) != null)
				{
					
				}
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		else {
			Scanner input = new Scanner(System.in);
			while (input.hasNext()) {
				
			}
		}
	}
	
	public void set(String name, int value) {
		if (db.containsKey(name)) {
			db.put(name, db.get(name).add(value));
			
		}
	}
	
	public int get(String name) {
		return 0;
	}
	
	public void unset(String name) {
		
	}
	
	public void numEqualTo(int num) {
		
	}
	
	public void end() {
		
	}
	
	public void rollback() {
		
		// TODO
	}
	
	public void commit() {
		
	}

}
