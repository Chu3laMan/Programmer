<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="author" content="colorlib.com">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />
    <link href="main.css" rel="stylesheet" />
    <style><%@include file="/styles/search.css"%></style> 
  </head>
  <body>
    <header>
      <nav>
      <form action="SearchPage2" method="get">
		<input type="hidden" name="action2" value="login">
        <button class="btn1"> Login</button></a>
        </form>
        <form action="SearchPage3" method="get">
		<input type="hidden" name="action3" value="signup">
        <button class="btn2"> SignUp</button>
        </form>
      </nav>
    </header>
    <div class="s003">
    <p class="wrap-message"><i>${message}</i></p>
      <form action="searchPage" method="get">
      <input type="hidden" name="action" value="add">
        <div class="inner-form">
          <div class="input-field second-wrap">
            <input id="search" type="text" name="searchKeyword" placeholder="Enter Keywords? (e.g., Java)" />
          </div>
          <div class="input-field third-wrap">
            <button class="btn-search" type="button">
              <svg class="svg-inline--fa fa-search fa-w-16" aria-hidden="true" data-prefix="fas" data-icon="search" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                <path fill="currentColor" d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z"></path>
              </svg>
            </button>
          </div>
        </div>
      </form>
    </div>
  </body>
</html>