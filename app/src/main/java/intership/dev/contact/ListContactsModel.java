package intership.dev.contact;

public class ListContactsModel {
	int mAvtar;
	String mName;
	String mDecription;
	public ListContactsModel(String name, int avatar, String decription) {
		// TODO Auto-generated constructor stub
		super();
		this.mAvtar=avatar;
		this.mName=name;
		this.mDecription=decription;
	}
	public String getmDecription() {
		return mDecription;
	}

	public void setmDecription(String mDecription) {
		this.mDecription = mDecription;
	}
	public int getmAvtar() {
		return mAvtar;
	}
	public void setmAvtar(int mAvtar) {
		this.mAvtar = mAvtar;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}

}
