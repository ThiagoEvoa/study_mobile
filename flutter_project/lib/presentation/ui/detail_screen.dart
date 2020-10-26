import 'package:flutter/material.dart';
import 'package:flutter_project/data/model/person_model.dart';
import 'package:flutter_project/presentation/viewmodel/person_viewmodel.dart';
import 'package:provider/provider.dart';

class DetailScreen extends StatefulWidget {
  final PersonModel personModel;

  const DetailScreen({Key key, this.personModel}) : super(key: key);

  @override
  _DetailScreenState createState() => _DetailScreenState();
}

class _DetailScreenState extends State<DetailScreen> {
  PersonViewModel _personViewModel;

  @override
  void initState() {
    _personViewModel = context.read<PersonViewModel>();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    TextEditingController _textEditingController =
        TextEditingController(text: widget?.personModel?.name);

    return Scaffold(
      appBar: AppBar(
        title: Text('Detail'),
      ),
      body: Padding(
        padding: EdgeInsets.symmetric(horizontal: 10),
        child: Column(
          children: [
            TextField(
              controller: _textEditingController,
            ),
            RaisedButton(
              onPressed: () {
                if (widget.personModel != null) {
                  widget.personModel.name = _textEditingController.text;
                  _personViewModel.updatePerson(
                    personModel: widget.personModel,
                    context: context,
                  );
                } else {
                  _personViewModel.savePerson(
                    personModel: PersonModel(name: _textEditingController.text),
                    context: context,
                  );
                }
              },
              child: Text('Save'),
            ),
          ],
        ),
      ),
    );
  }
}
