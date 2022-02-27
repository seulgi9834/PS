class ParkingSystem {

    int []car = new int[4];
    public ParkingSystem(int big, int medium, int small) {
        
        car[1]=big;
        car[2]=medium;
        car[3]=small;

    }
    
    public boolean addCar(int carType) {
        if(car[carType]<=0){
            return false;
        }
        else{
            car[carType]--;
            return true;
        }
    }
}
