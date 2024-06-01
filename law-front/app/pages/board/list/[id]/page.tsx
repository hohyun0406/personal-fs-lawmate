"use client";

import {findBoardById} from "@/app/components/board/service/board-service";
import { DataGrid } from "@mui/x-data-grid";
import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";

export default function BoardDetail({ params }: any) {
  const dispatch = useDispatch();
  const [boards, setBoards] = useState([]);

  useEffect(() => {
    dispatch(findBoardById(params.id))
      .then((res: any) => {
        console.log(res);
        console.log(res.payload);
        setBoards(res.payload); // 데이터를 상태로 설정
      })
      .catch((error: any) => {
        console.error("Error:", error);
        alert("실패");
      });
  }, [params.id, dispatch]);

  const columns = [
    { field: "법령일련번호", headerName: "법령일련번호", width: 150 },
    { field: "현행연혁코드", headerName: "현행연혁코드", width: 150 },
    {
      field: "법령명한글",
      headerName: "법령명한글",
      width: 200,
      renderCell: (link) => {
        const lawLink = `http://www.law.go.kr${link.row.법령상세링크}`;
        return <a href={lawLink} target="_blank" rel="noopener noreferrer">{link.value}</a>;
      },
    },
    { field: "법령약칭명", headerName: "법령약칭명", width: 150 },
    { field: "법령ID", headerName: "법령ID", width: 150 },
    { field: "공포일자", headerName: "공포일자", width: 150 },
    { field: "공포번호", headerName: "공포번호", width: 150 },
    { field: "제개정구분명", headerName: "제개정구분명", width: 150 },
    { field: "소관부처코드", headerName: "소관부처코드", width: 150 },
    { field: "소관부처명", headerName: "소관부처명", width: 150 },
    { field: "법령구분명", headerName: "법령구분명", width: 150 },
    { field: "시행일자", headerName: "시행일자", width: 150 },
  ];

  return (
    <div style={{ height: 600, width: '100%' }}>
      <h1>안녕하세요</h1>
      <DataGrid
        rows={boards}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        getRowId={(row) => row.법령일련번호}
      />
    </div>
  );
}