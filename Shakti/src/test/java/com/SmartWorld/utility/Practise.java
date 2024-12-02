package com.SmartWorld.utility;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class Practise {
	public static void main(String [] args) {
		String [] arr={"java","java","ccc","c++","javascript"};
		HashMap<String , Integer> hm=new HashMap<String,Integer> ();
		for(String aa:arr) {
		if(hm.containsKey(aa)) {
		hm.put(aa,hm.get(aa)+1); }
		else {
		hm.put(aa,1); }
		     }
		System.out.println(hm);

		Set<Entry<String, Integer> > keySet=hm.entrySet();
		for(Entry<String,Integer> kv: keySet) {
		if(kv.getValue()>1) {
		System.out.println(kv.getKey()+":"+kv.getValue());

		}           } }}
