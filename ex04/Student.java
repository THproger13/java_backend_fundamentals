package ex04;

public class Student {
	
		private	int no;
		private	String name;
		private	String juso;
		private String phone;
		
		
		public Student() {
			
		}
		
		public Student(int no, String name, String juso,String phone) {
			super();
			this.no = no;
			this.name = name;
			this.juso = juso;
			this.phone = phone;
		}
		
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return juso;
		}
		public void setAddress(String juso) {
			this.juso  = juso;
		}
		public String getPhoneNum() {
			return phone;
		}
		public void setPhoneNum(String phoneNum) {
			this.phone = phoneNum;
		}
		@Override
		public String toString() {
			return "JusoVO [no=" + no + ", name=" + name + ", address=" + juso + ", phoneNum=" + phone + "]";
		}

		
		
		
}
