package lab.lab20240528;

public class Entry<Key extends Comparable<Key>, Value> {
  private Key ky;
  private Value val;
  public Entry(Key newKey, Value newValue) {
    this.ky = newKey;
    this.val = newValue;
  }

  // Getter and Setter Methods
  public Key getKey() { return ky; }
  public Value getValue() { return val; }
  public void setKey(Key newKey) { ky = newKey; }
  public void setValue(Value newValue) { val = newValue; }
}
