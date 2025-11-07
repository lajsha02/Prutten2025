public abstract class Component {
  public String name;
  public double weight;
  Component(String name, double weight) {
    this.name = name;
    this.weight = weight;

  }

  public abstract double getWeight();
  public abstract String toString();

}

