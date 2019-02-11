class MyHashC {
  Entry[] table;
  int elements;
  MyHashC(int size){
    table = new Entry[size];
    for(int i = 0;i < size; i++){
      table[i] = null;
    }
    elements = 0;
  }

  public int hash(String key){
    int r = 0;
    for(int i=0;i<key.length();i++){
      r = r + (int)(key.charAt(i));
    }
    return r % table.length;
  }

  public int hash2(String key){
    int r = 0;
    for(int i=0;i<key.length();i++){
      int buf = (int)(key.charAt(i));
      r = r + buf * buf;
    }
    return r % table.length;
  }

  private static class Entry{
    MyKeyword keyword;
    Entry next;
    Entry(MyKeyword keyword){
      this.keyword = keyword;
    }
  }

  public void insert(MyKeyword k){
        int myData = hash(k.getKey());        
        Entry nptr = new Entry(k);                
        if (table[myData] == null)
            table[myData] = nptr;            
        else
        {
            nptr.next = table[myData];
            table[myData] = nptr;
        } 
    return;
  }

  public MyKeyword search(String key){

  	for(Entry start = table[hash(key)]; start != null; start = start.next ){
  		if(key.equals(start.keyword.getKey())){
  			return start.keyword;
  		}
  	}
    return null;
  }

  public MyKeyword delete(String key){
  	int myData = hash(key); 
  	if(table[myData] == null){
  		return null;
  	}
  	if(key.equals(table[myData].keyword.getKey())){
  		Entry start = table[myData];
  		table[myData] = start.next;
  		return start.keyword;
  	}
  	Entry start;
  	Entry end;
    for(end = table[myData], start = end.next; start != null; end=start, start = start.next){
  		if(key.equals(start.keyword.getKey())){
  			end.next = start.next;
  			return start.keyword;
  		}
    }
    return null;
        
  }

  public String toString(){
    String str = "";
    boolean pef=false;
    boolean  ef=false;
    
    str = "table[0] -- [" + (table.length - 1) + "]\n";
    str = str + "=============================\n";
    for(int i = 0;i < table.length; i++){
      if (table[i] == null) {
        ef = true;
        if (pef == false){
          str = str + "   :   \n";
        }
      }else{
        ef = false;
        str = str + "table[" + i + "]";
        Entry t = table[i];
        while(t != null){
          str = str + "->(" + t.keyword + ") ";
          t = t.next;
        }
        str = str + "\n";
      }
      pef = ef;
    }
    str = str + "=============================\n";
    return str;
  }
}
