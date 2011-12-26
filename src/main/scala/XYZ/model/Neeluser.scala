package XYZ.model

import net.liftweb.mongodb.record._
import net.liftweb.record.field.StringField

/**
 * Created by IntelliJ IDEA.
 * User: nsachdeva
 * Date: 30/11/11
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */


class Neeluser extends MongoRecord[Neeluser] with MongoId[Neeluser]{

  def meta=Neeluser

  object firstname extends StringField(this, 20)
  object lastname extends StringField(this, 20)
  object company extends StringField(this, 20)
  object position extends StringField(this, 20)

}
object Neeluser extends Neeluser with MongoMetaRecord[Neeluser]{

}