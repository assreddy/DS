package dsimplementations;

class DataItem{
  int iData;
  public DataItem(int data){
    this.iData = data;
  }

  public int getKey(){
    return iData;
  }
}

public class HashTableImp {

  private DataItem[] hashArray;
  private int arraySize;
  DataItem nonItem;  // for deleted Items

  public HashTableImp(int size){
    arraySize = size;
    hashArray = new DataItem[arraySize];
    nonItem = new DataItem(-1); // deleted item key is -1
  }

  public void displayTable(){
    System.out.println("Table : ");
    for(int i= 0; i< arraySize; i++){
      if(hashArray[i] != null){
        System.out.print(hashArray[i].getKey() + " ");
      }else {
        System.out.print("** ");
      }
    }
    System.out.println("");

  }

  public int hashFunction(int key){
    return key % arraySize; // hash function.
  }

  public void insert(DataItem item){
    // Assume table not full
    int key = item.getKey();
    int hashValue = hashFunction(key);
    while(hashArray[hashValue] !=null && hashArray[hashValue].getKey() != -1){
      ++hashValue;
      hashValue %= arraySize;
    }
    System.out.print(hashValue +" ");
    hashArray[hashValue] = item;
  }

  public DataItem find(int key){

    int hashValue = hashFunction(key);
    while(hashArray[hashValue] != null){
      if(hashArray[hashValue].getKey() == key) {
        return hashArray[hashValue];
      }
      ++hashValue;
      hashValue %= arraySize;
    }
    return null;
  }

  public DataItem delete(int key){
    int hashValue = hashFunction(key);
    while(hashArray[hashValue] != null){
      if(hashArray[hashValue].getKey() == key){
        DataItem temp = hashArray[hashValue];
        hashArray[hashValue] = nonItem;
        return  temp;
      }
      ++hashValue;
      hashValue %= arraySize;
    }
    return null;
  }


  public static void main(String args[]){
    System.out.println("Testing");
    HashTableImp ht = new HashTableImp(5);
    DataItem item1 = new DataItem(10);
    DataItem item2 = new DataItem(20);
    DataItem item3 = new DataItem(30);

    ht.insert(item1);
    ht.insert(item2);
    ht.insert(item3);

    ht.displayTable();
    DataItem find = ht.find(20);
    System.out.println(find.getKey() +": " +find.iData);
    ht.delete(30);
    ht.displayTable();
  }
}
