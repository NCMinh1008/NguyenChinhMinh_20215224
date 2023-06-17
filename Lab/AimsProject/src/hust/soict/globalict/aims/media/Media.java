package hust.soict.globalict.aims.media;

public abstract class Media {
	
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Media otherMedia = (Media) obj;
	    try {
	        return title.equals(otherMedia.title);
	    } catch (NullPointerException e) {
	        return false;
	    } catch (ClassCastException e) {
	        return false;
	    }
	}
	
	public static final MediaComparatorByTitleCost COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final MediaComparatorByCostTitle COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
    public abstract void displayInfo();

}
