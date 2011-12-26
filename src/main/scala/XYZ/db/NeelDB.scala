package XYZ.db

import net.liftweb.mongodb._
import net.liftweb.util._
import net.liftweb.common._
import net.liftweb.json.DefaultFormats
import net.liftweb.json.JsonAST._
import net.liftweb.json.JsonParser._
import net.liftweb.json.JsonDSL._

import com.mongodb.{BasicDBObject, BasicDBObjectBuilder, DBObject}


/**
 * Created by IntelliJ IDEA.
 * User: nsachdeva
 * Date: 30/11/11
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */

object NeelDB {
  def setup {
    MongoDB.defineDb(DefaultMongoIdentifier, MongoAddress(MongoHost("127.0.0.1", 27017), "om"))
  }


  def isMongoRunning: Boolean = {
    try {
      MongoDB.use(DefaultMongoIdentifier)(db => {
        db.getLastError
      })
      true
    }
    catch {
      case e => false
    }
  }

}