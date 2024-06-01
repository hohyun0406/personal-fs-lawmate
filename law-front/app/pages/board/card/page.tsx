"use client";
import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActionArea } from "@mui/material";
import { useRouter } from "next/navigation";

interface LizardCardProps {
  id: number;
  image: string;
  title: string;
  description: string;
}

const LizardCard: React.FC<LizardCardProps> = ({
  id,
  image,
  title,
  description,
}) => {
  const router = useRouter();

  const handleCardClick = () => {
    router.push(`./list/${id}`);
  };

  return (
    <Card sx={{ maxWidth: 345 }} onClick={handleCardClick}>
      <CardActionArea>
        <CardMedia component="img" height="140" image={image} alt={title} />
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
};

export default function LawListPage() {
  const cardData = [
    {
      id: 1,
      image:
        "https://blog.kakaocdn.net/dn/WTKUj/btqCX8gKTGL/mplKe41JSu0EpEDDGCdfv1/img.jpg",
      title: "공법",
      description: "헌법 및 행정법",
    },
    {
      id: 2,
      image:
        "https://file.scourt.go.kr/crosseditor/images/000001/20180201143229221_KNQ6G3HM.jpg",
      title: "민사법",
      description: "「민법」, 「상법」 및 「민사소송법」",
    },
    {
      id: 3,
      image:
        "https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F2669873E55DFC1EF15",
      title: "형사법",
      description: "「형법」 및 「형사소송법」",
    },
    {
      id: 4,
      image:
        "https://www.blockchaintoday.co.kr/news/photo/202305/32423_36712_3857.jpg",
      title: "전문적 법률분야",
      description:
        "국제법, 국제거래법, 노동법, 조세법, 지적재산권법, 경제법, 환경법",
    },
  ];

  return (
    <>
      {cardData.map((card) => (
        <LizardCard
          key={card.id}
          id={card.id}
          image={card.image}
          title={card.title}
          description={card.description}
        />
      ))}
    </>
  );
}
