import javax.swing.*;

/* TODO
1. 라벨 2개 만들어서 하나는 선택한 것, 나머지는 정답 결과
2. 스코어 출력하는 라벨 추가
 */


public class CoinToss extends JFrame {

    String[] coinFace = {"앞면", "뒷면"};


    private int choice;
    private int score;

    JFrame frame = new JFrame();

    JLabel imgLbl = new JLabel();
    JLabel btnLbl = new JLabel(); // 버튼 눌렀을 때
    JLabel scrLbl = new JLabel(); // 점수 출력
    ImageIcon coinImg= new ImageIcon(CoinToss.class.getResource("/images/coin.png"));

    ImageIcon[] coinArr = {
            new ImageIcon(CoinToss.class.getResource("/images/coinFront.png")),
            new ImageIcon(CoinToss.class.getResource("/images/coinBack.png"))
    };


    JButton frontBtn = new JButton("앞면");
    JButton backBtn = new JButton("뒷면");

    CoinToss()
    {
        frame.setTitle("코인 토스 게임"); // 프로그램 이름
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null); // 창이 가운데 오게
        frame.setResizable(false); // 창 크기 변경 못하게
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게



        setButton();

        Init();




        frame.setVisible(true); // 눈에 보이기
    }


    void Init(){
        // 기본 이미지 생성
        setImage(coinImg);

        // 스코어 점수 표시
        score = 0;


        // "선택하시오" 문구 출력
        setLabel("앞면 혹은 뒷면을 선택하시오.");
    }

    void setLabel(String text){
        btnLbl.setBounds(75, 350,350,30);
        btnLbl.setText(text);
        btnLbl.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(btnLbl);

        scrLbl.setBounds(0,0,100, 30);
        scrLbl.setText("현재 점수 : "+score);
        frame.getContentPane().add(scrLbl);
    }

    void updateScoreLabel(){
        scrLbl.setText("현재 점수 : "+score);
    }

    void setButton(){
        frontBtn.setBounds(0,400, 250,50);
        backBtn.setBounds(250,400, 250,50);

        frame.getContentPane().add(frontBtn);
        frame.getContentPane().add(backBtn);

        frontBtn.addActionListener(e -> {
            btnLbl.setText("앞면을 선택했습니다.");
            choice = 0;
            gameStart();

        });

        backBtn.addActionListener(e -> {
            btnLbl.setText("뒷면을 선택했습니다.");
            choice = 1;
            gameStart();

        });
    }



    void setImage(ImageIcon img){
        imgLbl.setIcon(img);
        imgLbl.setBounds(75,50,300,300);
        imgLbl.setHorizontalAlignment(JLabel.CENTER);

        frame.getContentPane().add(imgLbl);
    }


    void gameStart(){
        //btnDisable(); // 버튼 비활성화

        int idx = (int)(Math.random() * 2);
        setImage(coinArr[idx]);
        setLabel("당신 : "+ coinFace[choice]+ " / "+ "상대 : "+ coinFace[idx]);

    if(choice == idx){
            score++;
            updateScoreLabel();
        }
    }

    void btnDisable(){
        frontBtn.setEnabled(false); // 버튼 비활성화
        backBtn.setEnabled(false); // 버튼 비활성화
    }

    void btnEnable(){
        frontBtn.setEnabled(true); // 버튼 활성화
        backBtn.setEnabled(true); // 버튼 활성화
    }

    public static void main(String[] args) {
        new CoinToss();
    }
}