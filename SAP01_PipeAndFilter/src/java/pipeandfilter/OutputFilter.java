package pipeandfilter;

public class OutputFilter  extends Filter{
    
    private String output;
    
    public OutputFilter(Pipe inPipe){
        super(inPipe, null);
        this.output = "";
    }
    
    @Override
    public void run(){
        while(true){
            String value = this.inPipe.PullData();
            if(value.equals("#DONE")){

                break;
            } else{
                output += value + "\n";
            }
        }
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public String getOutput(){
        return this.output;
    }
}
