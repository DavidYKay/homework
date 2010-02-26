public enum DaysOfWeek {
	SUNDAY    ( 0, "Sunday"    ),
	MONDAY    ( 1, "Monday"    ),
	TUESDAY   ( 2, "Tuesday"   ),
	WEDNESDAY ( 3, "Wednesday" ),
	THURSDAY  ( 4, "Thursday"  ),
	FRIDAY    ( 5, "Friday"    ),
	SATURDAY  ( 6, "Saturday"  );

	private final int value; 
	private final String name; 
	DaysOfWeek(int value, String name) {
		this.value = value;
		this.name = name;
	}
	public int getValue()   { return value; } 
	public String getName() { return name; } 
}
