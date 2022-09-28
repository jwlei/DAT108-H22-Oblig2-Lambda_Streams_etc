package ex2.task4.object;

import java.util.ArrayList;
import java.util.List;

public class ListOfKings {
	
	private static final String IMG_ROOT =
			"https://upload.wikimedia.org/wikipedia/commons/thumb/";

	public static List<King> getListOfKings() {
		return listOfKings;
	}

	public static List<King> listOfKings = new ArrayList<King>();
	
	static {
		listOfKings.add(new King("Christian I",		1426, 1448, 1482,
				IMG_ROOT + "c/c8/Medalj_%C3%B6ver_Kristian_I%2C_Nordisk_familjebok.png/100px-Medalj_%C3%B6ver_Kristian_I%2C_Nordisk_familjebok.png"));
		listOfKings.add(new King("Hans",			1455, 1482, 1513,
				IMG_ROOT + "5/52/John_II_of_Sweden_sculpture_c_1530_%28photo_2009%29.jpg/100px-John_II_of_Sweden_sculpture_c_1530_%28photo_2009%29.jpg"));
		listOfKings.add(new King("Christian II",	1481, 1513, 1523,
				IMG_ROOT + "0/09/ChristianIIb.jpg/100px-ChristianIIb.jpg"));
		listOfKings.add(new King("Frederik I",		1471, 1523, 1535,
				IMG_ROOT + "2/2c/Frederik1dk.jpg/100px-Frederik1dk.jpg"));
		listOfKings.add(new King("Christian III",	1503, 1535, 1559,
				IMG_ROOT + "b/b8/Christian_III_of_Denmark.jpg/100px-Christian_III_of_Denmark.jpg"));
		listOfKings.add(new King("Frederik II",		1534, 1559,	1588,
				IMG_ROOT + "7/7a/Frederik_2.jpg/100px-Frederik_2.jpg"));
		listOfKings.add(new King("Christian IV",	1577, 1588, 1648,
				IMG_ROOT + "c/cb/Christian_IV_of_Denmark.jpg/100px-Christian_IV_of_Denmark.jpg"));
	}
}
