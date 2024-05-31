"use client";
import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActionArea } from "@mui/material";

interface LizardCardProps {
  image: string;
  title: string;
  description: string;
}

const LizardCard: React.FC<LizardCardProps> = ({ image, title, description }) => (
  <Card sx={{ maxWidth: 345 }}>
    <CardActionArea>
      <CardMedia
        component="img"
        height="140"
        image={image}
        alt={title}
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          {title}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {description}
        </Typography>
      </CardContent>
    </CardActionArea>
  </Card>
);

export default function LawListPage() {
  const cardData = [
    {
      image: "https://img.thedailybeast.com/image/upload/c_crop,d_placeholder_euli9k,h_1440,w_2560,x_0,y_0/dpr_1.5/c_limit,w_908/fl_lossy,q_auto/v1531451526/180712-Weill--The-Creator-of-Pepe-hero_uionjj",
      title: "Lizard",
      description: "Lizards are a widespread group of squamate reptiles, with over 6,000 species, ranging across all continents except Antarctica",
    },
    {
      image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV454DgEvmIa6TZP3UwBnlfwTRBS1RBdI0Hw&s",
      title: "Lizard",
      description: "Lizards are a widespread group of squamate reptiles, with over 6,000 species, ranging across all continents except Antarctica",
    },
    {
      image: "https://www.blockchaintoday.co.kr/news/photo/202305/32423_36712_3857.jpg",
      title: "Lizard",
      description: "Lizards are a widespread group of squamate reptiles, with over 6,000 species, ranging across all continents except Antarctica",
    },
    {
      image: "https://www.blockchaintoday.co.kr/news/photo/202305/32423_36712_3857.jpg",
      title: "Lizard",
      description: "Lizards are a widespread group of squamate reptiles, with over 6,000 species, ranging across all continents except Antarctica",
    },
    {
      image: "https://www.blockchaintoday.co.kr/news/photo/202305/32423_36712_3857.jpg",
      title: "Lizard",
      description: "Lizards are a widespread group of squamate reptiles, with over 6,000 species, ranging across all continents except Antarctica",
    },
    {
      image: "https://www.blockchaintoday.co.kr/news/photo/202305/32423_36712_3857.jpg",
      title: "Lizard",
      description: "Lizards are a widespread group of squamate reptiles, with over 6,000 species, ranging across all continents except Antarctica",
    },
  ];

  return (
    <>
      {cardData.map((card, index) => (
        <LizardCard
          key={index}
          image={card.image}
          title={card.title}
          description={card.description}
        />
      ))}
    </>
  );
}
