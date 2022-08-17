package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import beans.Facility;
import beans.FacilityStatus;
import beans.FacilityType;
import beans.FacilityContent;

public class FacilityDao {
	
	private Map<Integer, Facility> facilities = new HashMap<>();
	private String filepath = "";
}