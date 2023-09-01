import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RoadCar extends JFrame {

	// 宣告
	ImageIcon[] road = new ImageIcon[10];
	ImageIcon[] carstar = new ImageIcon[7];
	ImageIcon[] carstar1 = new ImageIcon[5];
	ImageIcon[] carbanana = new ImageIcon[16];

	ImageIcon rock = new ImageIcon("img/rock.gif");
	ImageIcon stopwatch = new ImageIcon("img/Stopwatch.gif");
	ImageIcon money = new ImageIcon("img/money.gif");
	ImageIcon moneybag = new ImageIcon("img/moneybag.gif");
	ImageIcon heart = new ImageIcon("img/slife.gif");
	ImageIcon noheart = new ImageIcon("img/nolife.gif");
	ImageIcon car = new ImageIcon("img/car.gif");
	ImageIcon car1 = new ImageIcon("img/car1.gif");
	ImageIcon car2 = new ImageIcon("img/car2.gif");
	ImageIcon car3 = new ImageIcon("img/car3.gif");
	ImageIcon car4 = new ImageIcon("img/car4.gif");
	ImageIcon cover = new ImageIcon("img/cover.gif");
	ImageIcon board = new ImageIcon("img/board.jpg");
	ImageIcon trophy = new ImageIcon("img/trophy.gif");
	ImageIcon shield = new ImageIcon("img/shield.gif");
	ImageIcon start = new ImageIcon("img/start.gif");
	ImageIcon banana = new ImageIcon("img/banana.gif");
	ImageIcon end = new ImageIcon("img/end.jpg");
	ImageIcon hitrock = new ImageIcon("img/hitrock.gif");
	ImageIcon hitmoney = new ImageIcon("img/hitmoney.gif");
	ImageIcon hitheart = new ImageIcon("img/hitheart.gif");
	ImageIcon hitshield = new ImageIcon("img/hitshield.gif");
	ImageIcon hitstar = new ImageIcon("img/hitstar.gif");
	ImageIcon shieldcover = new ImageIcon("img/shieldcover.gif");
	ImageIcon star = new ImageIcon("img/star.gif");
	ImageIcon bomb = new ImageIcon("img/bomb.gif");
	ImageIcon explosion = new ImageIcon("img/explosion.gif");

	int speed = 27;
	int road_id = 0;
	int rock_id = 0;
	int heart_id = 0;
	int money_id = 0;
	int money1_id = 0;
	int shield_id = 0;
	int bomb_id = 0;
	int star_id = 0;
	int carstar_id = 0;
	int banana_id = 0;
	int carbanana_id = 0;
	int total = 0;
	int ranktop = 0;
	int life = 3;
	int put_heart = -1;
	int put_money = -1;
	int put_money1 = -1;
	int put_rock = -1;
	int put_shield = -1;
	int put_star = -1;
	int put_bomb = -1;
	int put_banana = -1;
	int time = 0;
	int t = 0;
	int hitrock_t = 0;
	int hitheart_t = 0;
	int hitmoney_t = 0;
	int hitmoney1_t = 0;
	int hitshield_t = 0;
	int hitstar_t = 0;
	int hitbomb_t = 0;
	int hitbanana_t = 0;
	int car_positionx = 80;
	int car_positiony = 295;
	int[] rock_positionx = new int[1000];
	int[] rock_positiony = new int[1000];
	int[] rock1_positionx = new int[1000];
	int[] rock1_positiony = new int[1000];
	int[] heart_positionx = new int[1000];
	int[] heart_positiony = new int[1000];
	int[] money_positionx = new int[1000];
	int[] money_positiony = new int[1000];
	int[] money1_positionx = new int[1000];
	int[] money1_positiony = new int[1000];
	int[] shield_positionx = new int[1000];
	int[] shield_positiony = new int[1000];
	int[] star_positionx = new int[1000];
	int[] star_positiony = new int[1000];
	int[] bomb_positionx = new int[1000];
	int[] bomb_positiony = new int[1000];
	int[] banana_positionx = new int[1000];
	int[] banana_positiony = new int[1000];

	boolean isStart = false;
	boolean isHit_rock = false;
	boolean isHit_heart = false;
	boolean isHit_money = false;
	boolean isHit_money1 = false;
	boolean isHit_shield = false;
	boolean isHit_star = false;
	boolean isHit_bomb = false;
	boolean isHit_banana = false;
	boolean open_rock_t = false;
	boolean open_heart_t = false;
	boolean open_money_t = false;
	boolean open_shield_t = false;
	boolean open_cover_t = false;
	boolean open_star_t = false;
	boolean open_star_t1 = false;
	boolean open_bomb_t = false;
	boolean open_banana_t = false;
	boolean open_carbanana = false;

	boolean[] isDoble_rock = new boolean[1000];
	// boolean isDouble_rock = false;

	Random r = new Random();
	Timer timer = new Timer();

	// 主程式
	public static void main(String[] args) {
		RoadCar roadCar = new RoadCar();

		roadCar.setVisible(true);
	}

	// 組織
	public RoadCar() {

		initFrame();
		initRoad();

		Panel panel = new Panel();
		this.add(panel);

		Action action = new Action();
		this.addKeyListener(action);
		this.setFocusable(true);

		timer.schedule(new Timertask(), 1000, speed);
	}

	// frame
	void initFrame() {
		this.setTitle("Road Car Game");
		int w = 1000;
		int h = 550;
		this.setSize(w, h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;

		this.setLocation((sw - w) / 2, (sh - h) / 2);
	}

	// 初始化
	void initRoad() {
		if (time > ranktop) {
			ranktop = time;
		}

		road_id = 0;
		rock_id = 0;
		heart_id = 0;
		money_id = 0;
		money1_id = 0;
		shield_id = 0;
		star_id = 0;
		bomb_id = 0;
		banana_id = 0;
		carbanana_id = 0;

		hitrock_t = 0;
		hitheart_t = 0;
		hitmoney_t = 0;
		hitshield_t = 0;
		hitstar_t = 0;
		hitbomb_t = 0;
		hitbanana_t = 0;

		t = 0;
		time = 0;
		life = 3;

		put_heart = -1;
		put_money = -1;
		put_rock = -1;
		put_shield = -1;
		put_star = -1;
		put_bomb = -1;
		put_banana = -1;
		put_money1 = -1;

		isStart = false;
		isHit_rock = false;
		isHit_heart = false;
		isHit_money = false;
		isHit_money1 = false;
		isHit_shield = false;
		isHit_star = false;
		isHit_bomb = false;
		isHit_banana = false;

		open_rock_t = false;
		open_heart_t = false;
		open_money_t = false;
		open_shield_t = false;
		open_cover_t = false;
		open_star_t = false;
		open_star_t1 = false;
		open_bomb_t = false;
		open_banana_t = false;
		open_carbanana = false;

		isDoble_rock = new boolean[1000];

		heart_positionx = new int[1000];
		heart_positiony = new int[1000];
		rock_positionx = new int[1000];
		rock_positiony = new int[1000];
		rock1_positionx = new int[1000];
		rock1_positiony = new int[1000];
		money_positionx = new int[1000];
		money_positiony = new int[1000];
		money1_positionx = new int[1000];
		money1_positiony = new int[1000];
		shield_positionx = new int[1000];
		shield_positiony = new int[1000];
		star_positionx = new int[1000];
		star_positiony = new int[1000];
		bomb_positionx = new int[1000];
		bomb_positiony = new int[1000];
		banana_positionx = new int[1000];
		banana_positiony = new int[1000];

		car_positionx = 80;
		car_positiony = 295;
		heart_positionx[0] = 860;
		heart_positiony[0] = r.nextInt(3) * 95 + 200;
		rock_positionx[0] = 860;
		rock_positiony[0] = r.nextInt(3) * 95 + 200;
		money_positionx[0] = 860;
		money_positiony[0] = r.nextInt(3) * 95 + 200;
		money1_positionx[0] = 860;
		money1_positiony[0] = r.nextInt(3) * 95 + 200;
		shield_positionx[0] = 860;
		shield_positiony[0] = r.nextInt(3) * 95 + 200;
		star_positionx[0] = 860;
		star_positiony[0] = r.nextInt(3) * 95 + 200;
		banana_positionx[0] = 860;
		banana_positiony[0] = r.nextInt(3) * 95 + 200;
	}

	// 物件放置
	void put_Object() {

		// 放石頭

		if (rock_positionx[rock_id] == 460) {
			rock_id++;
			rock_positionx[rock_id] = 880;
			rock_positiony[rock_id] = r.nextInt(3) * 95 + 200;

			put_rock = r.nextInt(3);

			if (put_rock == 0) {
				isDoble_rock[rock_id] = true;
				rock1_positionx[rock_id] = 880;

				if (rock_positiony[rock_id] == 390) {
					rock1_positiony[rock_id] = 200;
				} else {
					rock1_positiony[rock_id] = rock_positiony[rock_id] + 95;
				}
			}
		}
//------------------------------------------------------------------------------
		// 放愛心

		// 重製
		if (isHit_heart || heart_positionx[heart_id] == 60) {
			put_heart = -1;
			isHit_heart = false;
		}

		// 不同時有兩個愛心 和 三條生命時不有愛心
		if (put_heart != 0 && life == 1) {

			put_heart = r.nextInt(500);

			if (put_heart == 0) {
				heart_id++;
				heart_positionx[heart_id] = 880;
				heart_positiony[heart_id] = r.nextInt(3) * 95 + 200;
			}
		}
//------------------------------------------------------------------------------
		// 放錢
		if (isHit_money || money_positionx[money_id] == 60) {
			put_money = -1;
			isHit_money = false;
		}

		if (put_money != 0) {

			put_money = r.nextInt(5);

			if (put_money == 0) {
				money_id++;
				money_positionx[money_id] = 880;
				money_positiony[money_id] = r.nextInt(3) * 95 + 200;
			}
		}

		// 放錢1

		if (isHit_money1 || money1_positionx[money1_id] == 60) {
			put_money1 = -1;
			isHit_money1 = false;
		}

		if (put_money1 != 0) {

			put_money1 = r.nextInt(11);

			if (put_money1 == 0) {
				money1_id++;
				money1_positionx[money1_id] = 880;
				money1_positiony[money1_id] = r.nextInt(3) * 95 + 200;
			}
		}

//------------------------------------------------------------------------------
		// 放盾牌
		if (isHit_shield || shield_positionx[shield_id] == 60) {
			put_shield = -1;
			isHit_shield = false;
		}

		if (put_shield != 0 && !open_cover_t) {

			put_shield = r.nextInt(300);

			if (put_shield == 0) {

				shield_id++;
				shield_positionx[shield_id] = 880;

				if (put_shield == 0) {
					shield_id++;
					shield_positionx[shield_id] = 880;
					shield_positiony[shield_id] = r.nextInt(3) * 95 + 200;
				}
			}
		}
//------------------------------------------------------------------------------
		// 放星星
		if (isHit_star || star_positionx[star_id] == 60) {
			put_star = -1;
			isHit_star = false;
		}

		if (put_star != 0 && !open_star_t && !open_star_t1) {

			put_star = r.nextInt(700);

			if (put_star == 0) {

				star_id++;
				star_positionx[star_id] = 880;

				if (put_star == 0) {
					star_id++;
					star_positionx[star_id] = 880;
					star_positiony[star_id] = r.nextInt(3) * 95 + 200;
				}
			}
		}
//------------------------------------------------------------------------------
		// 放炸彈
		if (isHit_bomb || bomb_positionx[bomb_id] == 60) {
			put_bomb = -1;
			isHit_bomb = false;
		}

		if (put_bomb != 0) {

			put_bomb = r.nextInt(250);

			if (put_bomb == 0) {
				bomb_id++;
				bomb_positionx[bomb_id] = 880;
				bomb_positiony[bomb_id] = r.nextInt(3) * 95 + 200;
			}
		}
//------------------------------------------------------------------------------
		// 放香蕉皮
		if (isHit_banana || banana_positionx[banana_id] == 60) {
			put_banana = -1;
			isHit_banana = false;
		}

		if (put_banana != 0) {

			put_banana = r.nextInt(100);

			if (put_banana == 0) {
				banana_id++;
				banana_positionx[banana_id] = 880;
				banana_positiony[banana_id] = r.nextInt(3) * 95 + 200;
			}
		}

	}

	// 物件跑動
	void run_Object() {

		if (isDoble_rock[rock_id]) {
			if (rock1_positionx[rock_id] > 60) {
				rock1_positionx[rock_id] -= 20;
			}
		}

		if (rock_positionx[rock_id] > 60) {
			rock_positionx[rock_id] -= 20;
		}
//-----------------------------------------------------
		if (rock_id > 0) {
			if (isDoble_rock[rock_id - 1]) {
				if (rock1_positionx[rock_id - 1] > 60) {
					rock1_positionx[rock_id - 1] -= 20;
				}
			}

			if (rock_positionx[rock_id - 1] > 60) {
				rock_positionx[rock_id - 1] -= 20;
			}
		}
//-----------------------------------------------------
		if (put_heart == 0) {
			if (heart_positionx[heart_id] > 60) {
				heart_positionx[heart_id] -= 20;
			}
		}
//-----------------------------------------------------
		if (put_money == 0) {
			if (money_positionx[money_id] > 60) {
				money_positionx[money_id] -= 20;
			}
		}

		if (put_money1 == 0) {
			if (money1_positionx[money1_id] > 60) {
				money1_positionx[money1_id] -= 20;
			}
		}
//-----------------------------------------------------
		if (put_shield == 0) {
			if (shield_positionx[shield_id] > 60) {
				shield_positionx[shield_id] -= 20;
			}
		}
//-----------------------------------------------------
		if (put_star == 0) {
			if (star_positionx[star_id] > 60) {
				star_positionx[star_id] -= 20;
			}
		}
//-----------------------------------------------------
		if (put_bomb == 0) {
			if (bomb_positionx[bomb_id] > 60) {
				bomb_positionx[bomb_id] -= 20;
			}
		}
// -----------------------------------------------------
		if (put_banana == 0) {
			if (banana_positionx[banana_id] > 60) {
				banana_positionx[banana_id] -= 20;
			}
		}
	}

	// 撞到物件
	void hit_Object() {

		isHit_rock = false;
		boolean hit = car_positionx + 20 == rock_positionx[rock_id] && car_positiony == rock_positiony[rock_id];
		boolean hit1 = car_positionx == rock_positionx[rock_id] && car_positiony == rock_positiony[rock_id];

		if (hit || hit1) {
			isHit_rock = true;
		}
//-----------------------------------------------------------------------------------------------------------------
		hit = car_positionx + 20 == rock1_positionx[rock_id] && car_positiony == rock1_positiony[rock_id];
		hit1 = car_positionx == rock1_positionx[rock_id] && car_positiony == rock1_positiony[rock_id];

		if (hit || hit1) {
			isHit_rock = true;
		}
//-----------------------------------------------------------------------------------------------------------------
		if (rock_id > 0) {
			hit = car_positionx + 20 == rock_positionx[rock_id - 1] && car_positiony == rock_positiony[rock_id - 1];
			hit1 = car_positionx == rock_positionx[rock_id - 1] && car_positiony == rock_positiony[rock_id - 1];

			if (hit || hit1) {
				isHit_rock = true;
			}

			hit = car_positionx + 20 == rock1_positionx[rock_id - 1] && car_positiony == rock1_positiony[rock_id - 1];
			hit1 = car_positionx == rock1_positionx[rock_id - 1] && car_positiony == rock1_positiony[rock_id - 1];

			if (hit || hit1) {
				isHit_rock = true;
			}
		}
//-----------------------------------------------------------------------------------------------------------------		
		hit = car_positionx + 20 == heart_positionx[heart_id] && car_positiony == heart_positiony[heart_id]
				&& put_heart == 0;
		hit1 = car_positionx == heart_positionx[heart_id] && car_positiony == heart_positiony[heart_id]
				&& put_heart == 0;

		if (hit || hit1) {
			isHit_heart = true;
			life++;
		}
//-----------------------------------------------------------------------------------------------------------------
		hit = car_positionx + 20 == money_positionx[money_id] && car_positiony == money_positiony[money_id]
				&& put_money == 0;
		hit1 = car_positionx == money_positionx[money_id] && car_positiony == money_positiony[money_id]
				&& put_money == 0;

		if (hit || hit1) {
			isHit_money = true;
			total += 100;
		}
//-----------------------------------------------------------------------------------------------------------------
		hit = car_positionx + 20 == money1_positionx[money1_id] && car_positiony == money1_positiony[money1_id]
				&& put_money1 == 0;
		hit1 = car_positionx == money1_positionx[money1_id] && car_positiony == money1_positiony[money1_id]
				&& put_money1 == 0;

		if (hit || hit1) {
			isHit_money1 = true;
			total += 100;
		}
//-----------------------------------------------------------------------------------------------------------------
		hit = car_positionx + 20 == shield_positionx[shield_id] && car_positiony == shield_positiony[shield_id]
				&& put_shield == 0;
		hit1 = car_positionx == shield_positionx[shield_id] && car_positiony == shield_positiony[shield_id]
				&& put_shield == 0;

		if (hit || hit1) {
			isHit_shield = true;
		}
//-----------------------------------------------------------------------------------------------------------------
		hit = car_positionx + 20 == star_positionx[star_id] && car_positiony == star_positiony[star_id]
				&& put_star == 0;
		hit1 = car_positionx == star_positionx[star_id] && car_positiony == star_positiony[star_id] && put_star == 0;

		if (hit || hit1) {
			isHit_star = true;
		}
//-----------------------------------------------------------------------------------------------------------------
		hit = car_positionx + 20 == bomb_positionx[bomb_id] && car_positiony == bomb_positiony[bomb_id]
				&& put_bomb == 0;
		hit1 = car_positionx == bomb_positionx[bomb_id] && car_positiony == bomb_positiony[bomb_id] && put_bomb == 0;

		if (hit || hit1) {
			isHit_bomb = true;
		}
//-----------------------------------------------------------------------------------------------------------------
		hit = car_positionx + 20 == banana_positionx[banana_id] && car_positiony == banana_positiony[banana_id]
				&& put_banana == 0;
		hit1 = car_positionx == banana_positionx[banana_id] && car_positiony == banana_positiony[banana_id]
				&& put_banana == 0;

		if (hit || hit1) {
			isHit_banana = true;
		}
	}

	// 畫面
	class Panel extends JPanel {
		public Panel() {
			road_img();
			this.setBackground(Color.black);

		}

		@Override
		public void paint(Graphics g) {

			super.paint(g);

			g.drawImage(road[road_id].getImage(), 50, 180, null);
			board.paintIcon(this, g, 50, 30);

			if (!open_rock_t && !open_heart_t && !open_money_t && !open_shield_t && !open_cover_t && !open_star_t
					&& !open_star_t1 && !open_bomb_t && !open_banana_t && !open_carbanana) {
				car.paintIcon(this, g, car_positionx, car_positiony);
			}
//----------------------------------------------------------------------------------------------
			if (rock_positionx[rock_id] >= 60) {
				rock.paintIcon(this, g, rock_positionx[rock_id], rock_positiony[rock_id]);
			}

			if (isDoble_rock[rock_id]) {
				if (rock1_positionx[rock_id] >= 60) {
					rock.paintIcon(this, g, rock1_positionx[rock_id], rock1_positiony[rock_id]);
				}
			}
//----------------------------------------------------------------------------------------------
			if (rock_id > 0) {
				if (rock_positionx[rock_id - 1] >= 60) {
					rock.paintIcon(this, g, rock_positionx[rock_id - 1], rock_positiony[rock_id - 1]);
				}

				if (isDoble_rock[rock_id - 1]) {
					if (rock1_positionx[rock_id - 1] >= 60) {
						rock.paintIcon(this, g, rock1_positionx[rock_id - 1], rock1_positiony[rock_id - 1]);
					}
				}
			}
//----------------------------------------------------------------------------------------------
			if (put_heart == 0 && heart_positionx[heart_id] >= 60) {
				heart.paintIcon(this, g, heart_positionx[heart_id], heart_positiony[heart_id]);
			}
//----------------------------------------------------------------------------------------------
			if (put_money == 0 && money_positionx[money_id] >= 60) {
				money.paintIcon(this, g, money_positionx[money_id], money_positiony[money_id]);
			}
			
			if (put_money1 == 0 && money1_positionx[money1_id] >= 60) {
				money.paintIcon(this, g, money1_positionx[money1_id],money1_positiony[money1_id]);
			}
//----------------------------------------------------------------------------------------------
			if (put_shield == 0 && shield_positionx[shield_id] >= 60) {
				shield.paintIcon(this, g, shield_positionx[shield_id], shield_positiony[shield_id]);
			}
//----------------------------------------------------------------------------------------------
			if (put_star == 0 && star_positionx[star_id] >= 60) {
				star.paintIcon(this, g, star_positionx[star_id], star_positiony[star_id]);
			}
//----------------------------------------------------------------------------------------------
			if (put_bomb == 0 && bomb_positionx[bomb_id] >= 60) {
				bomb.paintIcon(this, g, bomb_positionx[bomb_id], bomb_positiony[bomb_id]);
			}
//----------------------------------------------------------------------------------------------
			if (put_banana == 0 && banana_positionx[banana_id] >= 60) {
				banana.paintIcon(this, g, banana_positionx[banana_id], banana_positiony[banana_id]);
			}
//----------------------------------------------------------------------------------------------
			if (isHit_rock) {
				open_rock_t = true;
			}

			if (open_rock_t) {
				hitrock_t++;

				if (open_cover_t) {
					shieldcover.paintIcon(this, g, car_positionx + 25, car_positiony - 10);

					if (hitrock_t == 5) {
						open_rock_t = false;
						open_cover_t = false;
						hitrock_t = 0;
					}
				} else if (open_star_t || open_star_t1) {
					hitstar.paintIcon(this, g, car_positionx + 25, car_positiony - 10);

					if (hitrock_t == 5) {
						open_rock_t = false;
						hitrock_t = 0;
					}
				} else {
					hitrock.paintIcon(this, g, car_positionx + 55, car_positiony - 20);
					car1.paintIcon(this, g, car_positionx, car_positiony);

					if (hitrock_t == 5) {
						open_rock_t = false;
						hitrock_t = 0;
						life--;
					}
				}
			}
//----------------------------------------------------------------------------------------------
			if (isHit_shield) {
				open_shield_t = true;
				open_cover_t = true;
			}

			if (open_shield_t) {
				hitshield_t++;
				hitshield.paintIcon(this, g, car_positionx + 55, car_positiony);

				if (hitshield_t == 5) {
					open_shield_t = false;
					hitshield_t = 0;

				}
			}

			if (open_cover_t) {
				cover.paintIcon(this, g, car_positionx - 10, car_positiony + 15);
				car4.paintIcon(this, g, car_positionx, car_positiony);
			}
//----------------------------------------------------------------------------------------------
			if (isHit_heart) {
				open_heart_t = true;
			}

			if (open_heart_t) {
				hitheart_t++;
				hitheart.paintIcon(this, g, car_positionx + 55, car_positiony - 10);
				car2.paintIcon(this, g, car_positionx, car_positiony);

				if (hitheart_t == 5) {
					open_heart_t = false;
					hitheart_t = 0;

				}
			}

//----------------------------------------------------------------------------------------------
			if (isHit_money) {
				open_money_t = true;
			}

			if (isHit_money1) {
				open_money_t = true;
			}

			if (open_money_t) {
				hitmoney_t++;
				hitmoney.paintIcon(this, g, car_positionx + 50, car_positiony);
				car3.paintIcon(this, g, car_positionx, car_positiony);

				if (hitmoney_t == 5) {
					open_money_t = false;
					hitmoney_t = 0;

				}

			}
//----------------------------------------------------------------------------------------------
			if (isHit_banana) {
				open_banana_t = true;
			}

			if (open_banana_t) {
				hitbanana_t++;

				if (open_cover_t) {
					shieldcover.paintIcon(this, g, car_positionx + 25, car_positiony - 10);

					if (hitbanana_t == 5) {
						open_banana_t = false;
						open_cover_t = false;
						hitbanana_t = 0;
					}
				} else if (open_star_t || open_star_t1) {
					hitstar.paintIcon(this, g, car_positionx + 25, car_positiony - 10);

					
						open_banana_t = false;
						hitbanana_t = 0;
					
				} else {
					g.drawImage(carbanana[carbanana_id].getImage(), car_positionx, car_positiony, null);
					open_carbanana = true;

					if (hitbanana_t == 37) {
						open_carbanana = false;
						open_banana_t = false;
						hitbanana_t = 0;
					}
				}

			}
//----------------------------------------------------------------------------------------------
			if (isHit_star) {
				open_star_t = true;
			}

			
			
			if (open_star_t) {
				hitstar_t++;
				g.drawImage(carstar[carstar_id].getImage(), car_positionx, car_positiony, null);

				if (hitstar_t == 204) {
					open_star_t = false;
					open_star_t1 = true;
				}
				
				open_carbanana = false;
				open_banana_t = false;
				hitbanana_t = 0;
			}

			if (open_star_t1) {
				hitstar_t++;
				g.drawImage(carstar1[carstar_id].getImage(), car_positionx, car_positiony, null);

				if (hitstar_t == 238) {
					open_star_t1 = false;
					hitstar_t = 0;
				}
				
				open_carbanana = false;
				open_banana_t = false;
				hitbanana_t = 0;
			}
//----------------------------------------------------------------------------------------------
			if (isHit_bomb) {
				open_bomb_t = true;
			}

			if (open_bomb_t) {
				hitbomb_t++;

				if (open_cover_t) {
					shieldcover.paintIcon(this, g, car_positionx + 25, car_positiony - 10);

					if (hitbomb_t == 5) {
						open_bomb_t = false;
						open_cover_t = false;
						hitbomb_t = 0;
					}
				} else if (open_star_t || open_star_t1) {
					hitstar.paintIcon(this, g, car_positionx + 25, car_positiony - 10);

					if (hitbomb_t == 5) {
						open_bomb_t = false;
						hitbomb_t = 0;
					}
				} else {
					open_bomb_t = false;
					hitbomb_t = 0;
					life = 0;
					explosion.paintIcon(this, g, bomb_positionx[bomb_id] + 10, bomb_positiony[bomb_id] - 12);
				}

			}

//----------------------------------------------------------------------------------------------
			if (life == 3) {
				heart.paintIcon(this, g, 80, 65);
				heart.paintIcon(this, g, 140, 65);
				heart.paintIcon(this, g, 200, 65);
			}
			if (life == 2) {
				noheart.paintIcon(this, g, 80, 65);
				heart.paintIcon(this, g, 140, 65);
				heart.paintIcon(this, g, 200, 65);
			}
			if (life == 1) {
				noheart.paintIcon(this, g, 80, 65);
				noheart.paintIcon(this, g, 140, 65);
				heart.paintIcon(this, g, 200, 65);
			}
			if (life == 0) {
				noheart.paintIcon(this, g, 80, 65);
				noheart.paintIcon(this, g, 140, 65);
				noheart.paintIcon(this, g, 200, 65);
			}
//----------------------------------------------------------------------------------------------
			if (!isStart && life != 0) {
				start.paintIcon(this, g, 235, 275);
			}
//----------------------------------------------------------------------------------------------
			if (life == 0) {
				end.paintIcon(this, g, 50, 275);
			}
//----------------------------------------------------------------------------------------------
			stopwatch.paintIcon(this, g, 280, 65);
			g.setColor(Color.black);
			g.setFont(new Font("微軟正黑體", Font.BOLD, 30));
			if (time >= 60) {
				g.drawString(time / 60 + "分" + time % 60 + "秒", 340, 105);
			} else {
				g.drawString(time + "秒", 340, 105);
			}
//----------------------------------------------------------------------------------------------
			moneybag.paintIcon(this, g, 475, 65);
			g.drawString("$" + total + "", 530, 105);
			trophy.paintIcon(this, g, 680, 65);
			if (ranktop >= 60) {
				g.drawString(ranktop / 60 + "分" + ranktop % 60 + "秒", 740, 105);
			} else {
				g.drawString(ranktop + "秒", 740, 105);
			}

		}

		void road_img() {

			road[0] = new ImageIcon("img/road0.jpg");
			road[1] = new ImageIcon("img/road1.jpg");
			road[2] = new ImageIcon("img/road2.jpg");
			road[3] = new ImageIcon("img/road3.jpg");
			road[4] = new ImageIcon("img/road4.jpg");
			road[5] = new ImageIcon("img/road5.jpg");
			road[6] = new ImageIcon("img/road6.jpg");
			road[7] = new ImageIcon("img/road7.jpg");
			road[8] = new ImageIcon("img/road8.jpg");
			road[9] = new ImageIcon("img/road9.jpg");

			carstar[0] = new ImageIcon("img/star0.gif");
			carstar[1] = new ImageIcon("img/star1.gif");
			carstar[2] = new ImageIcon("img/star2.gif");
			carstar[3] = new ImageIcon("img/star3.gif");
			carstar[4] = new ImageIcon("img/star4.gif");
			carstar[5] = new ImageIcon("img/star5.gif");
			carstar[6] = new ImageIcon("img/star6.gif");

			carstar1[0] = new ImageIcon("img/car.gif");
			carstar1[1] = new ImageIcon("img/car.gif");
			carstar1[2] = new ImageIcon("img/car.gif");
			carstar1[3] = new ImageIcon("img/car0.gif");
			carstar1[4] = new ImageIcon("img/car0.gif");

			/*
			 * carbanana[0] = new ImageIcon("img/banana0.gif"); carbanana[1] = new
			 * ImageIcon("img/banana1.gif"); carbanana[2] = new
			 * ImageIcon("img/banana2.gif"); carbanana[3] = new
			 * ImageIcon("img/banana3.gif"); carbanana[4] = new
			 * ImageIcon("img/banana4.gif"); carbanana[5] = new
			 * ImageIcon("img/banana5.gif"); carbanana[6] = new
			 * ImageIcon("img/banana6.gif"); carbanana[7] = new
			 * ImageIcon("img/banana7.gif");
			 */
			carbanana[0] = new ImageIcon("img/banana0.gif");
			carbanana[1] = new ImageIcon("img/banana0.gif");
			carbanana[2] = new ImageIcon("img/banana1.gif");
			carbanana[3] = new ImageIcon("img/banana1.gif");
			carbanana[4] = new ImageIcon("img/banana2.gif");
			carbanana[5] = new ImageIcon("img/banana2.gif");
			carbanana[6] = new ImageIcon("img/banana3.gif");
			carbanana[7] = new ImageIcon("img/banana3.gif");
			carbanana[8] = new ImageIcon("img/banana4.gif");
			carbanana[9] = new ImageIcon("img/banana4.gif");
			carbanana[10] = new ImageIcon("img/banana5.gif");
			carbanana[11] = new ImageIcon("img/banana5.gif");
			carbanana[12] = new ImageIcon("img/banana6.gif");
			carbanana[13] = new ImageIcon("img/banana6.gif");
			carbanana[14] = new ImageIcon("img/banana7.gif");
			carbanana[15] = new ImageIcon("img/banana7.gif");
		}

	}

	// 動畫
	class Timertask extends TimerTask {
		@Override
		public void run() {
			if (isStart && life != 0) {
				road_id++;
				road_id %= 9;
				t++;

				if (t % 37 == 0) {
					t = 0;
					time++;
				}
				put_Object();
				run_Object();
				hit_Object();

				if (open_star_t) {
					carstar_id++;
					carstar_id %= 7;
				}

				if (open_star_t1) {
					carstar_id++;
					carstar_id %= 5;
				}

				if (open_carbanana) {
					carbanana_id++;
					carbanana_id %= 16;
				}

			} else {

			}

			repaint();
		}

	}

	// 行動

	// 行動
	class Action implements KeyListener {
		public void keyPressed(KeyEvent e) {
			int KeyCode = e.getKeyCode();

			if (KeyCode == KeyEvent.VK_ENTER && life != 0) {
				isStart = true;
			}

			if (KeyCode == KeyEvent.VK_SPACE) {
				isStart = false;
			}

			if (KeyCode == KeyEvent.VK_ENTER && life == 0) {
				initRoad();
			}

			if ((KeyCode == KeyEvent.VK_RIGHT || KeyCode == KeyEvent.VK_D) && car_positionx != 840 && isStart
					&& life != 0 && !open_carbanana) {
				car_positionx += 20;
			}

			if ((KeyCode == KeyEvent.VK_LEFT || KeyCode == KeyEvent.VK_A) && car_positionx != 60 && isStart && life != 0
					&& !open_carbanana) {
				car_positionx -= 20;
			}

			if ((KeyCode == KeyEvent.VK_UP || KeyCode == KeyEvent.VK_W) && car_positiony != 200 && isStart && life != 0
					&& !open_carbanana) {
				car_positiony -= 95;
			}

			if ((KeyCode == KeyEvent.VK_DOWN || KeyCode == KeyEvent.VK_S) && car_positiony != 390 && isStart
					&& life != 0 && !open_carbanana) {
				car_positiony += 95;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

	}

}
