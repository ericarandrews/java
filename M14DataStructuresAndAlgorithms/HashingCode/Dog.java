import java.util.Objects;

public class Dog {
	
	private String name, breed;
	private int age;
	private boolean rabiesVaccinated;
	
	public Dog(String name, String breed, int age, boolean rabiesShot) {
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.rabiesVaccinated = rabiesShot;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age >= 0) {
			this.age = age;
		}
	}
	public boolean isRabiesVaccinated() {
		return rabiesVaccinated;
	}
	public void setRabiesShot(boolean rabiesShot) {
		this.rabiesVaccinated = rabiesShot;
	}
	
	@Override
	public String toString() {
		return name + " (" + age + " years)" + 
				(!rabiesVaccinated ? " (Requires Shot)" : "");
	}

	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (rabiesVaccinated ? 1231 : 1237);
		return result;
	}
	*/
	@Override
	public int hashCode() {
		return Objects.hash(name, breed, age, rabiesVaccinated);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Dog) {
			Dog otherDog = (Dog) obj;
			return name.equals(otherDog.name) && breed.equals(otherDog.breed)
					&& age==otherDog.age && rabiesVaccinated==otherDog.rabiesVaccinated;
		} else {
			return false;
		}
	}
	
	
	

	

}
