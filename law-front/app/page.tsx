"use client";

import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Paper from "@mui/material/Paper";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import { useRouter } from "next/navigation";
import { useDispatch } from "react-redux";
import { useForm } from "react-hook-form";
import { loginUser } from "./components/user/service/user-service";
import { parseCookies, setCookie } from "nookies";
import { jwtDecode } from "jwt-decode";

const theme = createTheme();

export default function LogInPage() {
  const router = useRouter();
  const dispatch = useDispatch();

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const onSubmit = async (data: any) => {
    console.log(data);

    dispatch(loginUser(data))
      .then((res: any) => {
        console.log("서버에서 넘어온 RES " + JSON.stringify(res));
        console.log("서버에서 넘어온 메시지 1 " + res.payload.message);
        console.log("서버에서 넘어온 토큰 1 " + res.payload.accessToken);
        setCookie({}, "message", res.payload.message, {
          httpOnly: false,
          path: "/",
        });
        setCookie({}, "accessToken", res.payload.accessToken, {
          httpOnly: false,
          path: "/",
        });
        console.log("서버에서 넘어온 메시지 2 " + parseCookies().message);
        console.log("서버에서 넘어온 토큰 2 " + parseCookies().accessToken);
        console.log("토큰을 디코드한 내용 : ");
        console.log(jwtDecode<any>(parseCookies().accessToken));

        alert("로그인 성공");
        router.push("/pages/board/list"); // 회원가입 성공 시 login 페이지로 이동
      })
      .catch((error: any) => {
        console.error("Error:", error);
        alert("로그인 실패");
      });
  };

  return (
    <ThemeProvider theme={theme}>
      <Grid container component="main" sx={{ height: "100vh" }}>
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
            backgroundImage:
              "url(https://images3.alphacoders.com/133/thumb-1920-1332803.png)",
            backgroundRepeat: "no-repeat",
            backgroundColor: (t) =>
              t.palette.mode === "light"
                ? t.palette.grey[50]
                : t.palette.grey[900],
            backgroundSize: "cover",
            backgroundPosition: "center",
          }}
        />
        <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
          <Box
            sx={{
              my: 8,
              mx: 4,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
              Sign in
            </Typography>
            <Box
              component="form"
              noValidate
              onSubmit={handleSubmit(onSubmit)}
              sx={{ mt: 1 }}
            >
              <TextField
                margin="normal"
                required
                fullWidth
                id="username"
                label="ID"
                {...register("username", { required: true })}
                autoComplete="current-username"
                autoFocus
              />
              <TextField
                margin="normal"
                required
                fullWidth
                label="Password"
                type="password"
                id="password"
                {...register("password", { required: true })}
                autoComplete="current-password"
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Sign In
              </Button>
              <Grid container>
                <Grid item xs>
                  <Link href="#" variant="body2">
                    Forgot password?
                  </Link>
                </Grid>
                <Grid item>
                  <Link href="/pages/user" variant="body2">
                    {"Don't have an account? Sign Up"}
                  </Link>
                </Grid>
              </Grid>
            </Box>
          </Box>
        </Grid>
      </Grid>
    </ThemeProvider>
  );
}
