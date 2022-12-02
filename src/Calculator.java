import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton numberbtn[]=new JButton[10];
    JButton functionbtn[]=new JButton[9];
    JButton addBtn,subBtn,mulBtn,divBtn;
    JButton decBtn,equBtn,delBtn,clrBtn,negBtn;
    JPanel panel;

    Font myfont=new Font("Ink Free",Font.BOLD,30);

    double num1=0, num2=0 , result=0;

    char Operator;

    Calculator(){
        frame=new JFrame("Pramod's Calculator ");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield=new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myfont);
        textfield.setEditable(false);
        frame.add(textfield);

        addBtn=new JButton("+");
        subBtn=new JButton("-");
        mulBtn=new JButton("*");
        divBtn=new JButton("/");
        decBtn=new JButton(".");
        equBtn=new JButton("=");
        delBtn=new JButton("Del");
        clrBtn=new JButton("Clr");
        negBtn=new JButton("-");

        functionbtn[0]=addBtn;
        functionbtn[1]=subBtn;
        functionbtn[2]=mulBtn;
        functionbtn[3]=divBtn;
        functionbtn[4]=decBtn;
        functionbtn[5]=equBtn;
        functionbtn[6]=delBtn;
        functionbtn[7]=clrBtn;
        functionbtn[8]=negBtn;

        for(int i=0;i<9;i++){
            functionbtn[i].addActionListener(this);
            functionbtn[i].setFont(myfont);
            functionbtn[i].setFocusable(false);
        }
        for(int i=0;i<10;i++){
            numberbtn[i]=new JButton(i+"");
            numberbtn[i].addActionListener(this);
            numberbtn[i].setFont(myfont);
            numberbtn[i].setFocusable(false);
        }

        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.RED);

        //add buttons to the panel
        panel.add(numberbtn[1]);
        panel.add(numberbtn[2]);
        panel.add(numberbtn[3]);
        panel.add(addBtn);
        panel.add(numberbtn[4]);
        panel.add(numberbtn[5]);
        panel.add(numberbtn[6]);
        panel.add(subBtn);
        panel.add(numberbtn[7]);
        panel.add(numberbtn[8]);
        panel.add(numberbtn[9]);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numberbtn[0]);
        panel.add(equBtn);
        panel.add(divBtn);

        negBtn.setBounds(50,430,100,50);
        delBtn.setBounds(150,430,100,50);
        clrBtn.setBounds(250,430,100,50);

        frame.add(panel);
        frame.add(negBtn);
        frame.add(delBtn);
        frame.add(clrBtn);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==numberbtn[i]){
                textfield.setText(textfield.getText().concat(i+""));
            }
        }
        if(e.getSource()==addBtn){
            num1=Double.parseDouble(textfield.getText());
            Operator='+';
            textfield.setText("");
        }
        if(e.getSource()==subBtn){
            num1=Double.parseDouble(textfield.getText());
            Operator='-';
            textfield.setText("");
        }
        if(e.getSource()==mulBtn){
            num1=Double.parseDouble(textfield.getText());
            Operator='*';
            textfield.setText("");
        }
        if(e.getSource()==divBtn){
            num1=Double.parseDouble(textfield.getText());
            Operator='/';
            textfield.setText("");
        }
        if(e.getSource()==decBtn){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==equBtn){
            num2=Double.parseDouble(textfield.getText());

            switch(Operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clrBtn){
            textfield.setText("");
        }
        if(e.getSource()==delBtn){
            String string=textfield.getText();
            textfield.setText(string.substring(0,string.length()-1));

        }
        if(e.getSource()==negBtn){
            Double temp=Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
    }

    public static void main(String[] args) {
        Calculator calculator=new Calculator();
    }
}
