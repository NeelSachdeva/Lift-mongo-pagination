package XYZ.snippet

import XYZ.model.Neeluser
import xml.NodeSeq
import com.mongodb.QueryBuilder
import net.liftweb.mongodb.{Skip, Limit}
import net.liftweb.util._
import Helpers._
import scala.xml._
import net.liftweb.http.{SHtml, PaginatorSnippet, StatefulSnippet}
import net.liftweb.http.S._

/**
* Created by IntelliJ IDEA.
* User: nsachdeva
* Date: 30/11/11
* Time: 2:16 PM
* To change this template use File | Settings | File Templates.
*/

object NeeluserSnippet extends StatefulSnippet with PaginatorSnippet[Neeluser] {

  var dispatch:DispatchIt={
    case "showAll" => showAll _
    case "editForm" => editForm _
    case "paginate" => paginate _
  }

  var editingNeeluser=Neeluser.createRecord


  def editForm(xhtml:NodeSeq):NodeSeq={
      ( "#editfirstname" #> editingNeeluser.firstname.toForm &
        "#editlastname" #> editingNeeluser.lastname.toForm &
        "#editcompany" #> editingNeeluser.company.toForm &
        "#editposition" #> editingNeeluser.position.toForm &
        "type=submit" #> SHtml.submit(?("Save") ,() => save )) .apply(xhtml)

  }

  override def count=Neeluser.count

  def showAll(xhtml:NodeSeq):NodeSeq={
    page.flatMap(neeluser => {
      (".firstname *" #> neeluser.firstname &
      ".lastname *" #> neeluser.lastname &
      ".company *" #> neeluser.company &
      ".position *" #> neeluser.position ).apply(xhtml)

    })

  }

  override def itemsPerPage = 2

  override def page = Neeluser.findAll(QueryBuilder.start().get(),Limit(itemsPerPage),Skip(curPage * itemsPerPage))

  def save={
    editingNeeluser.save
    redirectToHome
  }

  def redirectToHome={
    editingNeeluser=Neeluser.createRecord
    redirectTo("/neeluser")
  }

}