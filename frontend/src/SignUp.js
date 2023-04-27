import React, {useState} from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
//import FormControlLabel from '@mui/material/FormControlLabel';
//import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import FormHelperTexts from '@mui/material/FormHelperText';

const theme = createTheme();


export default function SignUp() {

  const [emailError, setEmailError] = useState('');
  const [passwordState, setPasswordState] = useState('');
  const [passwordError, setPasswordError] = useState('');
  const [NameError, setNameError] = useState('');
  const [nicknameError, setnicknameError] = useState('');
  const [registerError, setRegisterError] = useState('');
  const Navigate = useNavigate();

  const onhandlePost = async (data) => {
    const { email, Name, nickname, password } = data;
    const postData = { email, Name, nickname, password };

    // post
    await axios
      .post('/member/join', postData) //API 입력
      .then(function (response) {
        console.log(response, '성공');
        Navigate.push('/SignIn');
      })
      .catch(function (err) {
        console.log(err);
        setRegisterError('회원가입에 실패하였습니다. 다시한번 확인해 주세요.');
      });
      // TODO: 입력된 정보를 서버에 전송하는 로직 작성
  };
  const handleSubmit = (event) => {
    event.preventDefault(); // 기본 이벤트 동작 취소

    const data = new FormData(event.currentTarget);
    const joinData = {
      email: data.get('email'),
      name: data.get('name'),
      password: data.get('password'),
      rePassword: data.get('rePassword'),
      Name: data.get('Name'),
      nickname: data.get('nickname')
    };

    //이건 왜 하는데?
    const  { email, Name, nickname, password, rePassword } = joinData;

    // 유효성 검사

    //이메일 유효성 체크
    const emailRegex = /([\w-.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (!emailRegex.test(email)) setEmailError('올바른 이메일 형식이 아닙니다.');
    else setEmailError('');

    // 비밀번호 유효성 체크
    const passwordRegex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
    if (!passwordRegex.test(password))
      setPasswordState('숫자+영문자+특수문자 조합으로 8자리 이상 입력해주세요!');
    else setPasswordState('');

    // 비밀번호 같은지 체크
    if (password !== rePassword) setPasswordError('비밀번호가 일치하지 않습니다.');
    else setPasswordError('');

    // 이름 유효성 체크
    const nameRegex = /^[가-힣a-zA-Z]+$/;
    if (!nameRegex.test(Name) || Name.length < 1) setNameError('올바른 이름을 입력해주세요.');
    else setNameError('');

    //닉네임 유효성 체크
    if (nickname.length < 1) setnicknameError('닉네임을 입력해주세요.');
    else setnicknameError('');

    if (
      emailRegex.test(email) &&
      passwordRegex.test(password) &&
      password === rePassword &&
      nameRegex.test(Name) &&
      nickname.length > 0
    ) {
      onhandlePost(joinData); // 회원가입 정보 post
    }
  }
  return (
    <ThemeProvider theme={theme}>
    {/*Home button*/}
    <Link href="/">    
    <Button startIcon={<img src="/img/armoury_logo.png" alt="Armoury" width={60} height={60}/>} sx={{
      margin:1
      ,fontSize:30
      ,color:"black"
      }}>
      <strong>0xARMOURY</strong>
    </Button>
    </Link>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 10,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Avatar sx={{ m: 1, bgcolor:'white',width: 64, height: 64}}>
            <LockOutlinedIcon sx={{ fontSize: '60px', color: 'black' }}/>
          </Avatar>
          <Typography component="h1" fontSize={'30px'}>
            <strong>Sign Up</strong>
          </Typography>
          <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <TextField
                  autoComplete="given-name"
                  name="Name"
                  required
                  fullWidth
                  id="Name"
                  label="Name"
                  autoFocus
                  error={NameError !== '' || false}
                />
                 <FormHelperTexts sx={{color: '#DB0000'}}>{NameError}</FormHelperTexts>
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="nickname"
                  label="Nickame"
                  name="nickname"
                  autoComplete="nickname"
                  error={nicknameError !== '' || false}
                />
                 <FormHelperTexts sx={{color: '#DB0000'}}>{nicknameError}</FormHelperTexts>
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="email"
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                  error={emailError !== '' || false}
                />
                <FormHelperTexts sx={{color: '#DB0000'}}>{emailError}</FormHelperTexts>
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  name="password"
                  label="Password"
                  type="password"
                  id="password"
                  autoComplete="new-password"
                  error={passwordState !== '' || false}
                />
                 <FormHelperTexts sx={{color: '#DB0000'}}>{passwordState}</FormHelperTexts>
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  name="rePassword"
                  label="Confirm Password"
                  type="Password"
                  id="rePassword"
                  error={passwordError !== '' || false}
                />
                <FormHelperTexts sx={{color: '#DB0000'}}>{passwordError}</FormHelperTexts>
              </Grid>
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 1, bgcolor:"#363636" }}
            >
              Sign Up
            </Button>
            <FormHelperTexts sx={{color: '#DB0000'}}>{registerError}</FormHelperTexts>
            <Grid container justifyContent="flex-end">
              <Grid item sx={{mt:1}}>
                <Link href="./SignIn" variant="body2" color='#0000A5'>
                  {"Already have an account? Sign in"}
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Container>
    </ThemeProvider>
  );
}