package models;

public class TestModel {
	private static enum TestTypes {
		CLASS, INTERFACE, ENUM;
	}
	
	private TestTypes type = TestTypes.CLASS;
	private String string = "Testing";
	private int x = 20;
	private double lat = 1353.12341235;
	
}
