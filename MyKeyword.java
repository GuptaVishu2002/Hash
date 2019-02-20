class MyKeyword{
  private String key;
  private String data;

  MyKeyword(String key, String data){
    this.key  = key;
    this.data = data;
  }

  public String getKey(){
    return key;
  }

  public String getData(){
    return data;
  }

  public void setKey(String key){
    this.key = new String(key);
  }

  public void setData(String data){
    this.data = new String(data);
  }
   
    public boolean equals(MyKeyword key) {

        if (key == this) return true;
        if (!(key instanceof MyKeyword)) {
            return false;
        }

        MyKeyword myKeyword = (MyKeyword) key;

        return myKeyword.key.equals(key) &&
                myKeyword.key.equals(key);
    } 

  public String toString(){
    String str = key + " : ";
    if (data.length()>28){
      str = str + data.substring(0, 27) + "..";
    }else {
      str = str + data;
    }
    return str;
  }
  
  public String toStringAll(){
    return key + " : " + data;
  }
}
