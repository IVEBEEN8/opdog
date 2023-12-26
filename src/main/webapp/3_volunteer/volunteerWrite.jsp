<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="3_volunteer/css/volunteerWrite.css" />
  </head>
  <body>
    <form action="VtWriteC" method="post" enctype="multipart/form-data">
      <main>
        <table id="vTbl">
          <tr>
            <td class="write-td">title</td>
            <td>
              <input
                class="input-style"
                name="title"
                placeholder="Please enter the subject"
              />
            </td>
          </tr>
          <tr>
            <td class="write-td">img</td>
            <td><input class="input-style" name="file" type="file" /></td>
          </tr>
          <tr>
            <td class="write-td">content</td>
            <td>
              <textarea
                class="textarea-style"
                name="content"
                placeholder="Please enter your details"
              ></textarea>
            </td>
          </tr>
          <tr>
            <td colspan="2" class="write-td">
              <button>add</button>
            </td>
          </tr>
        </table>
      </main>
    </form>
  </body>
</html>