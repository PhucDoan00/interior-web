package doan.backend.service;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Override
	public String[] bedroom() {
		String[] bedroom = {"https://i.ibb.co/Y8CtnHW/Modern-Bedroom-Ideas.jpg",
							"https://i.ibb.co/yPYZK5v/Mid-Century-Ideas.jpg",
							"https://i.ibb.co/ZSz6BFS/Rustic-Bedroom-Ideas.jpg",
							"https://i.ibb.co/MZLWyw6/Eclectic-Bedroom-Ideas.jpg",
							"https://i.ibb.co/hVgP41W/Coastal-Bedroom-Ideas.jpg",
							"https://i.ibb.co/JC6XZRn/Industrial-Bedroom-Ideas.jpg",
							"https://i.ibb.co/sWsd2mH/traditional-Bedroom-Ideas.jpg",
							"https://i.ibb.co/ThsCpkR/Glam-Bedroom-Ideas.webp"};
		return bedroom;
	}
		
	@Override
	public String[] bedroombig() {
		String[] bedroombig = {"https://i.ibb.co/8Y4VG5W/Modern-Bedromm.png",
							   "https://i.ibb.co/X2Bxg28/Mid-Century.png",
							   "https://i.ibb.co/Wf3Q6wM/Rustic-Bedroom.png",
							   "https://i.ibb.co/BB8rvdJ/Eclectic-Bedroom.png",
							   "https://i.ibb.co/xCkJqTd/Coastal-Bedroom.png",
							   "https://i.ibb.co/M930jgg/Industrial-Bedroom.png",
							   "https://i.ibb.co/QHnFPZw/Traditional-Bedroom.png",
							   "https://i.ibb.co/CWmS9Zv/Glam-Bedroom.png"};
		return bedroombig;
	}
	
	@Override
	public String[] livingroomsmall() {
		String[] livingroomsmall = {"https://i.ibb.co/C77WQnB/Modern-Living-Room.png",
									"https://i.ibb.co/GFCrXmz/Mid-Century-Living-Room.png",
									"https://i.ibb.co/fFbNDRz/Rustic-Living-Room.png",
									"https://i.ibb.co/chF6vjZ/Eclectic-Living-Room.png",
									"https://i.ibb.co/5FjCwj5/Coastal-Living-Room.png",
									"https://i.ibb.co/b5TNGbn/Industrial-Living-Room.png",
									"https://i.ibb.co/WH1qdtp/Traditional-Living-Room.png",
									"https://i.ibb.co/c89PRSJ/Glam-Living-Room.png"};
		return livingroomsmall;
	}

	@Override
	public String[] livingroombig() {
		String[] livingroombig = {"https://i.ibb.co/4YMjP8R/modern.png",
				  				  "https://i.ibb.co/7JSntm1/midcentury.png",
				  				  "https://i.ibb.co/KqdSt8S/rustic.png",
				  				  "https://i.ibb.co/H4QLhDK/eclectic.png",
				  				  "https://i.ibb.co/K6m7bMp/coastal.png",
				  				  "https://i.ibb.co/18Nv6rN/industrial.png",
				  				  "https://i.ibb.co/x5w65w8/traditional.png",
				  				  "https://i.ibb.co/ykxVhcP/glam.png"};
		return livingroombig;
	}
	
	@Override
	public String[] categories() {
		String[] categories = {"https://i.ibb.co/qmLy4nB/bed.jpg",
							   "https://i.ibb.co/ccNd0Sz/dining.jpg",
							   "https://i.ibb.co/VQ8hbt4/office.jpg",
							   "https://i.ibb.co/VD6Bw2v/kids.jpg",
							   "https://i.ibb.co/4WCyZd3/living.jpg"};
		return categories;
	}
	
	@Override
	public String[] categoriesbigbrlr() {
		String[] c = {"https://i.ibb.co/SnzWSb3/main-Img-BR.png",
					  "https://i.ibb.co/fCMDWBF/mainImg.png"};
		return c;
	}
}
