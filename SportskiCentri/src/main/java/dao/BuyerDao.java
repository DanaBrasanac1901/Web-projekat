package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Type;

import beans.Admin;
import beans.Buyer;
import beans.BuyerRank;
import beans.BuyerType;
import beans.HistoryTraining;
import beans.InstantiatedMembership;
import dto.UserLoginDto;
import main.App;

public class BuyerDao {

	private String filepath = App.path + "/repository/Buyers.json";
	private Map<String, Buyer> buyers = new HashMap<>();
	private Buyer logBuyer;
	

	public Buyer getLogBuyer() {
		return logBuyer;
	}

	public void setLogBuyer(Buyer logBuyer) {
		this.logBuyer = logBuyer;
	}
	
	public void Delete(String username) {
		loadFile();
		buyers.get(username).setDeleted(true);
		updateFile();
		
	}
	
	public BuyerDao() {
	}

	public void loadFile() {

		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Reader reader = Files.newBufferedReader(Paths.get(filepath));
			Type typeOfHashMap = new TypeToken<Map<String, Buyer>>() {
			}.getType();
			buyers = gson.fromJson(reader, typeOfHashMap);
			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	public static String readFileAsString(String file) throws Exception {
		return new String(Files.readAllBytes(Paths.get(file)));
	}

	public void updateFile() {
		try {

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Writer writer = Files.newBufferedWriter(Paths.get(filepath));
			gson.toJson(buyers, writer);
			writer.close();

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}
	
	public boolean doesMembershipExist() {
		
		if(logBuyer.getMembership() == null) {
			return false;
		}
		
		return true;
		
	}

	public boolean doesUsernameExist(String username) {
		loadFile();
		if (buyers.values().stream().anyMatch(b -> b.getUsername().equals(username))) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public void updateFile() { ObjectMapper objectMapper = new ObjectMapper();
	 * objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	 * 
	 * try { objectMapper.writeValue(new FileOutputStream(filepath), buyers); }
	 * catch (IOException e) { System.out.println("Greska prilikom pisanja u fajl");
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public Buyer getByUsername(String username) {
		loadFile();
		return buyers.get(username);
	}

	public Collection<Buyer> getAll() {
		loadFile();
		return buyers.values();
	}

	public String addNew(Buyer newBuyer) {
		loadFile();
		if (doesUsernameExist(newBuyer.getUsername())) {
			return "ima";
		} else {
			buyers.put(newBuyer.getUsername(), newBuyer);
			updateFile();
			return "uspesno";
		}

	}

	/*
	 * public String RegisterNew(Buyer newBuyer) { loadFile();
	 * if(buyers.containsKey(newBuyer.getUsername())) {
	 * 
	 * return "ima";
	 * 
	 */
	public boolean isMembershipActive(InstantiatedMembership membership) {
		loadFile();
		if (membership.getExpirationDate().isBefore(LocalDate.now()) || membership.getRemainingEntrances() <= 0) {
			deactivateMembership(logBuyer);
			return false;
		} else if (!membership.isStatus()) {
			return false;
		}
		return true;

	}

	public void buyerHavingTraining(Buyer buyer) {
		loadFile();
		InstantiatedMembership membership = buyer.getMembership();
		if (membership.getRemainingEntrances() > 0) {
			membership.setRemainingEntrances(membership.getRemainingEntrances() - 1);
			updateFile();
			if(membership.getRemainingEntrances() == 0) {
				deactivateMembership(buyer);
			}
		} else {

			deactivateMembership(buyer);
		}

	}

	public void deactivateMembership(Buyer buyer) {
		loadFile();
		InstantiatedMembership membership = buyer.getMembership();

		if (membership.getRemainingEntrances() > 2 * (membership.getNumberOfEntrances()) / 3) {
			buyer.setPoints(buyer.getPoints() - membership.getPrice() / 1000 * 133 * 4);
		} else {
			buyer.setPoints(buyer.getPoints() + membership.getPrice() / 1000
					* (membership.getNumberOfEntrances() - membership.getRemainingEntrances()));
		}
		membership.setStatus(false);
		buyers.get(buyer.getUsername()).setMembership(membership);
		buyers.get(buyer.getUsername()).setPoints(buyer.getPoints());
		refreshPoints();
		updateFile();
	}

	public void newMembership(String username, InstantiatedMembership newMembership) {
		loadFile();
		getByUsername(username).setMembership(newMembership);
		updateFile();
	}

	public String loginBuyer(UserLoginDto user) {

		String username = user.getUsername();
		String password = user.getPassword();
		loadFile();

		if (buyers.containsKey(username)) {

			if (buyers.get(username).isBanned()) {
				return "banned";
			} else if (buyers.get(username).isDeleted()) {
				return "deleted";
			} else if (password.equals(buyers.get(username).getPassword())) {
				logBuyer = buyers.get(username);
				return "buyer";
			} else {
				return "wrong password";
			}

		}
		return "not";

	}
	

	public void addNewToTrainingHistory(String username, HistoryTraining trainingHistory) {
		loadFile();
		List<HistoryTraining> newTrainingHistory = buyers.get(username).getTrainingHistory();
		newTrainingHistory.add(trainingHistory);
		buyers.get(username).setTrainingHistory(newTrainingHistory);
		updateFile();
	}
	

	
	public Boolean DoesContainUsername(String username) {
		loadFile();

		if (buyers.containsKey(username)) {
			return true;
		}
		
		return false;
	}
	
	
	public Boolean DoesContainUsernameExecptLogged(String username) {
		loadFile();
		if(logBuyer.getUsername().contentEquals(username)) { 
			return false;
		}
		
		if (buyers.containsKey(username)) {
			return true;
		}
		
		return false;
	
	}
	
	public void Edit(Buyer a) {
		loadFile();
		System.out.println("Cao");
		a.setTrainingHistory(logBuyer.getTrainingHistory());
		a.setMembership(logBuyer.getMembership());
		a.setvisitedFacilitiesIds(logBuyer.getvisitedFacilitiesIds());
		a.setBuyerType(logBuyer.getBuyerType());
		buyers.remove(logBuyer.getUsername());
		buyers.put(a.getUsername(), a);
		logBuyer = a;
		updateFile();
		
	}
	
	public int getDiscount(int memPrice, int discount) {
		
		return (memPrice - memPrice*discount/100);
	}

	public void refreshPoints() {
		loadFile();
		if(logBuyer.getPoints() >= BuyerType.bronzePoints) {
		getByUsername(logBuyer.getUsername()).setBuyerType(new BuyerType(BuyerRank.BRONZE,BuyerType.bronzeDiscount));
		}else if(logBuyer.getPoints() >= BuyerType.silverPoints) {
			getByUsername(logBuyer.getUsername()).setBuyerType(new BuyerType(BuyerRank.SILVER,BuyerType.silverDiscount));
		}else if(logBuyer.getPoints() >= BuyerType.goldPoints) {
			getByUsername(logBuyer.getUsername()).setBuyerType(new BuyerType(BuyerRank.GOLD,BuyerType.goldDiscount));
		}else {
			getByUsername(logBuyer.getUsername()).setBuyerType(new BuyerType(BuyerRank.NO_RANK,BuyerType.no_discount));
		}
		updateFile();
	}

	
}
