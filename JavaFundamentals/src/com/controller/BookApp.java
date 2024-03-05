package com.controller;

import com.service.Dictionary;
import com.service.DictionaryE1;
import com.service.DictionaryE2;

public class BookApp {
	public static void main(String[] args) {
		Dictionary dictionary = new DictionaryE2();
		dictionary.authorInfo();
		dictionary.abstractInfo();
		dictionary.publishIndex();
		 
	}
}
